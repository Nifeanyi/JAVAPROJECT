package fr.epita.iam.service.dao;

import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exception.DeleteException;
import fr.epita.iam.exception.SaveException;
import fr.epita.iam.exception.SearchException;
import fr.epita.iam.exception.UpdateException;
import fr.epita.iam.service.dao.DAOResourceException;

public interface FileIdentityDAOInterface {
	
	public void save(Identity identity) throws SaveException ;
	
	public List<Identity> search(Identity criteria) throws SearchException ;
	
	public void update(Identity identity) throws UpdateException;
	
	public void delete(Identity identity) throws DeleteException ;
	
	public void releaseResources() throws DAOResourceException;
	

}
