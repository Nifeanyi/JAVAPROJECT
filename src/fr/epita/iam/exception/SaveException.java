/**
 * 
 */
package fr.epita.iam.exception;

import fr.epita.iam.datamodel.Identity;

/**
 * @author Nwadishifeanyi
 *
 */
public class SaveException extends Exception {

	private String saveFault;
	
	public SaveException(String string) {
		this.saveFault = getMessage();
	}

	public String getSaveFault() {
		return saveFault;
	}

	/**
	 * @param identity
	 */
	public void setFaultObject(Identity identity) {
		// TODO Auto-generated method stub
		
	}


}
