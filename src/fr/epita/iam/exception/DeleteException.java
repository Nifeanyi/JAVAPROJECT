/**
 * 
 */
package fr.vs.iamcorevishsharma.exception;

/**
 * @author Vishal
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
