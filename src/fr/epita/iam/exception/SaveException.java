/**
 * 
 */
package fr.epita.iam.exception;

/**
 * @author Nwadishifeanyi
 *
 */
public class SaveException extends Exception {

	private String saveFault;
	
	public SaveException(String message) {
		this.saveFault = message;
	}

	public String getSaveFault() {
		return saveFault;
	}


}
