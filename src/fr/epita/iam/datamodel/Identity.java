/**
 * 
 */
package fr.epita.iam.datamodel;

/**
 * @author Nwadishifeanyi
 *
 */
public class Identity {
	
	private String displayName;
	private String email;
	private String DOB;
	private String uid;
	
	
	
	
	/**
	 * @param displayName
	 * @param email
	 * @param DOB
	 * @param uid
	 */
	public Identity(String displayName, String email, String uid) {
		this.displayName = displayName;
		this.email = email;
		this.DOB = DOB;
		this.uid = uid;
	}
	
	
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
		/**
		 * @return the DOB
		 */
		public String getDOB() {
			return DOB;
		}
		/**
		 * @param DOB the DOB to set
		 */
		public void setDOB(String DOB) {
			this.DOB = DOB;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity [displayName=" + displayName + ", email=" + email
				+ ", DOB=" + DOB + ", uid=" + uid + "]";
	}
		
}
