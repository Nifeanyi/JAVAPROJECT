/**
 * 
 */
package fr.epita.iam.exception;

/**
 * @author Nwadishifeanyi
 * Exception for delete
 */
public class DeleteException extends Exception {
	private String deleteFault;
	
	/**
	 * @param message
	 */
	public DeleteException(String message) {
		this.deleteFault = message;
	}

	/**
	 * @return
	 */
	public String getDeleteFault() {
		return deleteFault;
	}

}
