/**
 * 
 */
package fr.vs.iamcorevishsharma.tests.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.vs.iamcorevishsharma.datamodel.Identity;
import fr.vs.iamcorevishsharma.exception.DeleteException;
import fr.vs.iamcorevishsharma.exception.InitializationException;
import fr.vs.iamcorevishsharma.exception.SaveException;
import fr.vs.iamcorevishsharma.exception.SearchException;
import fr.vs.iamcorevishsharma.exception.UpdateException;
import fr.vs.iamcorevishsharma.service.dao.DAOResourceException;
import fr.vs.iamcorevishsharma.service.dao.FileIdentityDAO;

/**
 * @author tbrou
 *
 */
public class TestJDBC {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws SaveException 
	 * @throws InitializationException 
	 * @throws SearchException 
	 * @throws UpdateException 
	 * @throws DeleteException 
	 * @throws DAOResourceException 
	 */
	public static void main(String[] args) throws SQLException, SaveException, InitializationException, SearchException, UpdateException, DeleteException, DAOResourceException {
		FileIdentityDAO dao = FileIdentityDAO.getInstance();
		System.out.println(dao.search(null));
		Identity identity = new Identity("Marie", "Bluntzer", null);
		System.out.println("before save");
		dao.save(identity);
		List<Identity> identities = dao.search(identity);
		System.out.println("after save");
		
		System.out.println(identities);
		identity = identities.get(0);
		identity.setDisplayName("Jeanne");
		dao.update(identity);
		
		System.out.println("after update");
		identities = dao.search(identity);
		System.out.println(identities);

		dao.delete(identity);
		
		System.out.println("after delete");
		identities = dao.search(identity);
		System.out.println(identities);
		dao.releaseResources();
		
		System.out.println("end of test");

	

		
	}

	private static void testJDBCConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Identities;create=true"
				, "tom", "tom");

		//prepare the query
		PreparedStatement prepareStatement = connection.prepareStatement("select * from IDENTITIES");
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()){
			String displayName = rs.getString("IDENTITY_DISPLAYNAME");
			System.out.println(displayName);
		}
		
		connection.close();
	}

}
