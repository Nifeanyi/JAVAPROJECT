/**
 * 
 */
package fr.vs.iamcorevishsharma.service.dao;

import fr.vs.iamcorevishsharma.exception.InitializationException;
import fr.vs.iamcorevishsharma.tests.service.dao.IdentityDAOInterface;

/**
 * @author Vishal
 *
 */
public class FileIdentityDAOFactory {
	
	
	public static IdentityDAOInterface getIdentityDAO() throws InitializationException{
		return FileIdentityDAO.getInstance();
	}

}
