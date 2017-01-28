/**
 * 
 */
package fr.vs.iamcorevishsharma.exception;


/**
 * @author Vishal
 * This is the search exception
 */
public class SearchException extends Exception {
	private String searchFault;
	
	/**
	 * @param message
	 */
	public SearchException(String message) {
		this.searchFault = message;
	}

	/**
	 * @return
	 */
	public String getSearchFault() {
		return searchFault;
	}

}
