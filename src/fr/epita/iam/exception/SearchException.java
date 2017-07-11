/**
 * 
 */
package fr.epita.iam.exception;


/**
 * @author Nwadishifeanyi
 * This is the search exception
 */
public class SearchException extends Exception {
	private String searchFault;
	
	/**
	 * @param string 
	 */
	public SearchException(String string) {
		this.searchFault = getMessage();
	}

	/**
	 * @return
	 */
	public String getSearchFault() {
		return searchFault;
	}

}
