/**
 * 
 */
package fr.epita.iam.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exception.DeleteException;
import fr.epita.iam.exception.ExceptionsMessages;
import fr.epita.iam.exception.InitializationException;
import fr.epita.iam.exception.SaveException;
import fr.epita.iam.exception.SearchException;
import fr.epita.iam.exception.UpdateException;
import fr.epita.iam.tests.service.dao.IdentityDAOInterface;

/**
 * This class is dealing with the Identity Persistence using a JDBC back-end
 * 
 * @author Nwadishifeanyi
 *
 */
public class FileIdentityDAO implements IdentityDAOInterface{

	private static final String IDENTITY_UID = "IDENTITY_UID";
	private static final String QUERY_ALL_IDENTITIES = "select * from IDENTITIES";
	private static final String QUERY_UPDATE_IDENTITY = 
			"update IDENTITIES set IDENTITY_EMAIL=?,IDENTITY_DISPLAYNAME=? where IDENTITY_UID=?";
	private static final String QUERY_DELETE_IDENTITY = 
			"delete from IDENTITIES where IDENTITY_UID=?";
	private static final String COLUMN_IDENTITY_DISPLAYNAME = "IDENTITY_DISPLAYNAME";
	private static final String CONF_USERNAME = "vish";
	private static final String CONF_PASSWORD = "vish";
	private static final String CONF_CONNECTION_STRING = "jdbc:derby://localhost:1527/Identities;create=true";
	private Connection connection;

	private static FileIdentityDAO instance;
	
	private FileIdentityDAO() throws InitializationException {
		try {
			this.connection = getConnection();
		} catch (SQLException e) {
			InitializationException die = new InitializationException(
					ExceptionsMessages.UNABLETOCONNECT);
			die.initCause(e);
			throw die;
		}
	}
	
	/**
	 * Singleton pattern
	 * @return
	 * @throws InitializationException
	 */
	public static FileIdentityDAO getInstance() throws InitializationException{
		if (instance == null){
			instance = new FileIdentityDAO();
		}
		return instance;	
	}

	public List<Identity> search(Identity criteria) throws SearchException {
		List<Identity> identities = new ArrayList<>();
		try {
			if(criteria == null){
				criteria = new Identity("","","");
			}
			Connection connection = getConnection();
			
			PreparedStatement prepareStatement = connection
					.prepareStatement(QUERY_ALL_IDENTITIES);
			prepareStatement.setString(1, criteria.getDisplayName());
			prepareStatement.setString(2, criteria.getEmail());
			prepareStatement.setString(3, criteria.getUid());  
			
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String displayName = rs.getString(COLUMN_IDENTITY_DISPLAYNAME);
				String uid = rs.getString(IDENTITY_UID);
				String email = rs.getString("IDENTITY_EMAIL");
				Identity identity = new Identity(displayName, email, uid);
				System.out.println("displayName"+ "uid"+"email");
				identities.add(identity);
			}

		} catch (SQLException e) {
			SearchException searchException = new SearchException("Searching Problem!");
			searchException.initCause(e);
			throw searchException;
		}
		System.out.println(identities);
		return identities;


	}

	public void save(Identity identity) throws SaveException {
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = 
					connection.prepareStatement("insert into IDENTITIES (IDENTITY_DISPLAYNAME, IDENTITY_EMAIL) values( ?, ?)");
			
			pstmt.setString(1, identity.getDisplayName());
			pstmt.setString(2, identity.getEmail());
			pstmt.execute();
			
			
		} catch (SQLException sqle) {
			SaveException dse = new SaveException("Error occured");
			dse.initCause(sqle);
			throw dse;
		}

	}

	private Connection getConnection() throws SQLException {
		if (this.connection == null || this.connection.isClosed()){
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			this.connection = DriverManager.getConnection(CONF_CONNECTION_STRING,
					CONF_USERNAME, CONF_PASSWORD);
		}
		return this.connection;
		
	}
	
	
	public void update(Identity identity) throws UpdateException{
		PreparedStatement prepareStatement;
		try {
			prepareStatement = getConnection().prepareStatement(QUERY_UPDATE_IDENTITY);
			prepareStatement.setString(1, identity.getEmail() );
			prepareStatement.setString(2, identity.getDisplayName() );
			prepareStatement.setString(3, identity.getUid());
			prepareStatement.execute();
		} catch (SQLException e) {
			UpdateException due = new UpdateException("Program cannot update the file");
			due.initCause(e);
			throw due;
		}
	}
	
	public void delete(Identity identity) throws DeleteException{
		PreparedStatement prepareStatement;
		try {
			prepareStatement = getConnection().prepareStatement(QUERY_DELETE_IDENTITY);
			prepareStatement.setString(1, identity.getUid());
			prepareStatement.execute();
		} catch (SQLException e) {
			DeleteException dde = new DeleteException("Unable to delete!");
			dde.initCause(e);
			throw dde;
		}
	}
	
	
	public void releaseResources() throws DAOResourceException{
		if (this.connection == null){
			return;
		}
		try {
			this.connection.close();
		} catch (SQLException e) {
			DAOResourceException re = new DAOResourceException();
			re.initCause(e);
			throw re;
		}
	}

}
