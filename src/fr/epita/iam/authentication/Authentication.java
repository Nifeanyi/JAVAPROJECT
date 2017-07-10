package fr.vs.iamcorevishsharma.authentication;

public class Authentication {
	
	public boolean authenticate(String username, String password) {
		// FIXME implement this authentication method
		if (username .equals("admin") && password .equals("admin"))
		return true;
		else 
			return false;
	}

}
