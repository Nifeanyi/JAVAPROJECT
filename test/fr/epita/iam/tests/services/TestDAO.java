/**
 * 
 */
package fr.epita.iam.tests.services;

import java.sql.SQLException;
import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exception.DeleteException;
import fr.epita.iam.exception.InitializationException;
import fr.epita.iam.exception.SaveException;
import fr.epita.iam.exception.SearchException;
import fr.epita.iam.exception.UpdateException;
import fr.epita.iam.service.dao.DAOResourceException;
import fr.epita.iam.service.dao.FileIdentityDAOFactory;
import fr.epita.iam.tests.service.dao.IdentityDAOInterface;

/**
 * @author tbrou
 *
 */
public class TestDAO {

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
	public static void main(String[] args) throws SaveException, InitializationException, SearchException, UpdateException, DeleteException, DAOResourceException {
		IdentityDAOInterface dao = FileIdentityDAOFactory.getIdentityDAO();
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
	
}
	

