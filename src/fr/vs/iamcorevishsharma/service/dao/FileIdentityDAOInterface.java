package fr.vs.iamcorevishsharma.service.dao;

import java.util.List;

import fr.vs.iamcorevishsharma.datamodel.Identity;
import fr.vs.iamcorevishsharma.exception.DeleteException;
import fr.vs.iamcorevishsharma.exception.SaveException;
import fr.vs.iamcorevishsharma.exception.SearchException;
import fr.vs.iamcorevishsharma.exception.UpdateException;
import fr.vs.iamcorevishsharma.service.dao.DAOResourceException;

public interface FileIdentityDAOInterface {
	
	public void save(Identity identity) throws SaveException ;
	
	public List<Identity> search(Identity criteria) throws SearchException ;
	
	public void update(Identity identity) throws UpdateException;
	
	public void delete(Identity identity) throws DeleteException ;
	
	public void releaseResources() throws DAOResourceException;
	

}
