/**
 * 
 */
package fr.epita.iam.service.dao;

import fr.epita.iam.exception.InitializationException;
import fr.epita.iam.tests.service.dao.IdentityDAOInterface;

/**
 * @author Nwadishifeanyi
 *
 */
public class FileIdentityDAOFactory {
	
	
	public static IdentityDAOInterface getIdentityDAO() throws InitializationException{
		return FileIdentityDAO.getInstance();
	}

}
