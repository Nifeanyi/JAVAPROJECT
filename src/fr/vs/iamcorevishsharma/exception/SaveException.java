/**
 * 
 */
package fr.vs.iamcorevishsharma.exception;

/**
 * @author Vishal
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
