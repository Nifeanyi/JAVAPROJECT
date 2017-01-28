/**
 * 
 */
package fr.vs.iamcorevishsharma.exception;


/**
 * @author Vishal
 * This is the initialization exception
 */
public class InitializationException extends Exception {
		
	private String initializationFault;
	
	private ExceptionsMessages message;
	
	/**
	 * @param message
	 */
	public InitializationException(String message) {
		this.initializationFault =  message;
	}
	
	/**
	 * @param message
	 */
	public InitializationException(ExceptionsMessages message) {
		this.message =  message;
	}

	/**
	 * @return
	 */
	public String getInitializationFault() {
		return initializationFault;
	}

	
	
}
