/**
 * 
 */
package fr.vs.iamcorevishsharma.launcher;

import java.io.IOException;
import java.util.Scanner;


import fr.vs.iamcorevishsharma.authentication.Authentication;
import fr.vs.iamcorevishsharma.datamodel.Identity;
import fr.vs.iamcorevishsharma.exception.DeleteException;
import fr.vs.iamcorevishsharma.exception.InitializationException;
import fr.vs.iamcorevishsharma.exception.SaveException;
import fr.vs.iamcorevishsharma.exception.UpdateException;
import fr.vs.iamcorevishsharma.service.dao.FileIdentityDAO;


/**
 * @author Vishal
 *
 */
public class ApplicationLaunch {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the IAM System");

		System.out.println("Please enter your user name: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		
		
		/**
		 * The Credentials are matched with the already set credentials.
		 */
		
		Authentication authService = new Authentication();
		if (!authService.authenticate(username, password)) {
			System.out.println("The provided credentials are wrong");
			System.out.println("The program will now exit\n");
			scanner.close();
			return;
		}
		FileIdentityDAO dao;
		
		try {
			
			dao = FileIdentityDAO.getInstance();
		} catch (InitializationException e) {
			System.out.println(e.getInitializationFault());
			System.out.println("unable to initialize, exiting");
			scanner.close();
			return;
		}
		
		/**
		 * 4 operations are presented to the user
		 * A while loop is created to repeat the operations until the exit operation is selected
		 */
		boolean repeat = true;
		while (repeat)
		{
		Identity identity;
		String displayName, email, uid;
		System.out.println("You're authenticated");
		System.out.println("Here are the actions you can perform :");
		System.out.println("a. Create an Identity");
		System.out.println("b. Modify an Identity");
		System.out.println("c. Delete an Identity");
		System.out.println("d. List Identities");
		System.out.println("e. quit");
		System.out.println("your choice (a|b|c|d|e) ? : ");
		String menuAnswer = scanner.nextLine();
		
		switch (menuAnswer) {
		/*
		 * case 1 - operation 1; create an Identity
		 */
		case "1":
			System.out.println("Creation Activity");

			System.out.print("Please enter the Identity display name");
			displayName = scanner.nextLine();
			
			System.out.print("Please enter the Identity email address");
			email = scanner.nextLine();
			
			
			identity = new Identity(displayName, email, null);
			
			System.out.println("Identity created");
			System.out.println("Identity display name = "+displayName);
			System.out.println("Identity email address = "+email +"\n");
			

			try {
				dao.save(identity);
			} catch (SaveException e) {
				System.out.println(e.getSaveFault());
			
			}
				
			break;
			/*
			 * Case 2 - operation 2; modify an Identity
			 */
		case "2":
			 
			System.out.println("Modification Activity");
			System.out.print("Please enter the Identity uid");
			uid = scanner.nextLine();
			System.out.print("Please enter the new Identity display name");
			displayName = scanner.nextLine();
			System.out.print("Please enter the new Identity email address");
			email = scanner.nextLine();
			
			identity = new Identity(displayName, email, uid);
			
			System.out.println("Identity updated");
			System.out.println("New Identity display name = "+displayName);
			System.out.println("New Identity email address = "+email+"\n");

			
			try {
				dao.update(identity);
			} catch (UpdateException e) {
				System.out.println(e.getUpdateFault());
			}

			
			break;
			/*
			 * case 3 - operation 3; Delete an identity
			 */
		case "3":
			 
			System.out.println("Deletion Activity");
			System.out.print("Please enter the Identity uid");
			uid = scanner.nextLine();
			
			
			identity = new Identity(null, null, uid);
			try {
				dao.delete(identity);
			} catch (DeleteException e) {
				System.out.println(e.getDeleteFault());
			}
			System.out.println("Identity deleted\n");
			break;

			/*
			 * case 4 - Exit; exits the while loop to exit the application
			 */
		case "4":
			System.out.println("The program will now exit\n");
			scanner.close();
			return;

		default:
			System.out.println("This option is not recognized ("+ menuAnswer + ")");
			break;
		}
		if (menuAnswer=="4")
			repeat=false;
		}
		scanner.close();
	}
	
}
