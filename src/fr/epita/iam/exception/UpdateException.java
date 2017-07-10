/**
 * 
 */
package fr.epita.iam.exception;


/**
 * @author Nwadishifeanyi
 *This is the update exception
 */
public class UpdateException extends Exception {
	private String updateFault;
	
	/**
	 * @param message
	 */
	public UpdateException(String message) {
		this.updateFault = message;
	}

	/**
	 * @return
	 */
	public String getUpdateFault() {
		return updateFault;
	}

}
