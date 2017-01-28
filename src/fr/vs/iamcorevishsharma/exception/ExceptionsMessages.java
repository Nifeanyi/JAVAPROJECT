package fr.vs.iamcorevishsharma.exception;

/**
 * @author Vishal
 *	the enum file for DAO exception messages
 */
public enum ExceptionsMessages {

		UNABLETOCONNECT ("unable to connect to the database", "DB"),
		
		;
		
		private String message;
		private String code;
		
		/**
		 * @param message
		 * @param code
		 */
		private ExceptionsMessages(String message, String code) {
			this.message = message;
			this.code = code;
		}
		
		/**
		 * @return
		 */
		public String getFormattedMessage(){
			return this.code + " : " + this.message;
		}

}
