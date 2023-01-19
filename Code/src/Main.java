import java.io.*;

public class Main {
	
	// signup feature
//	private static boolean signUp() {
//		boolean flag = false;
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//			System.out.println("Every detail is mandatory to fill..");
//			System.out.println("What is your first name ?");
//			String firstName = br.readLine();
//			System.out.println("What is your last name ?");
//			String lastName = br.readLine();
//			System.out.println("Your email address ?");
//			String email = br.readLine();
//			System.out.println("Your mobile number ?");
//			String mobile = br.readLine();
//			
//			// setting password
//			System.out.println("Set a good password for your account (length >= 8)");
//			String password = br.readLine();
//			
//			// password length should be greater than 8
//			while (password.length() < 8) {
//				System.out.println("password is too weak, increase its length");
//				password = br.readLine();
//			}
//			
//			// creating customer object
//			Customer customer = new Customer(firstName, lastName, email, mobile, password);
//			
//			// using customer object adding them to database
//			flag = customer.addCustomer();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
	
	/* ------------------------------------------ */
	
	
	// login feature
//	private static boolean login() {
//		System.out.println("Login Screen..");
//		boolean flag = false;
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//			System.out.print("Email: ");
//			String email = br.readLine();
//
//			System.out.print("Password: ");
//			String password = br.readLine();
//			
//			// creating customer object
//			Customer customer = new Customer(email, password);
//			// using customer object to verify the user
//			flag = customer.verifyCustomer();
//			
//			int count = 0; // count variable to limit number of time login attempt
//			boolean signup = false; // if user opted to choose signup because of lack of credentials
//			while (!flag && !signup && count < 5) {
//				System.out.println("Wrong email or password");
//				System.out.println("Press 1 for retry or Press 2 for SignUp");
//				
//				try {
//					int choice = br.read();
//					
//					// choice 49 means user pressed '1'. ASCII CODE of 1 is 49
//					if (choice == 49) {
//						// using readLine() because without it read() method is not skipping the line
//						br.readLine();
//						System.out.print("Email: ");
//						email = br.readLine();
//
//						System.out.print("Password: ");
//						password = br.readLine();
//
//						
//						customer = new Customer(email, password); // creating customer object
//						flag = customer.verifyCustomer(); // using customer object verifying
//						
//						// choice 50 means user pressed 2. ASCII CODE of 2 is 50
//					} else if (choice == 50) {
//						// using readLine() because without it read() method is not skipping the line
//						br.readLine();
//						signup = signUp();
//					} else {
//						br.readLine();
//						if(count < 4) System.out.println("select correct choice..."); // if user choose any character apart from 1 or 2
//					}
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//				count++;
//			}
//			
//			// if signup == true which means user created their account not logged in
//			if(signup) System.out.println("Account successfully created... Now you can login using your credentials");
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to HOTELO!.....");
		System.out.println("\n-------------------------------------");
		System.out.println("You want to login? If new user press 2 for sign up");
		/*
		 * 1. Login
		 * 2. SignUp
		 * 3. Exit
		 */
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			boolean flag = true;
			
			// there are 2 ways to exit from this loop, either user opted (i.e option == 3)
			// or user chose wrong option 3 times
			
			while (flag) {
				System.out.println("\nChoose options\n1. Login\n2. Signup\n3. Exit");
				int option = br.readLine().charAt(0) - '0';
				int count = 3;
				while(count > 0 && !(option == 1 || option == 2 || option == 3)) {
					System.out.println("\nTry again and choose correct options)");
					
					System.out.println("1. Login\n2. Signup\n3. EXIT");
					option = br.readLine().charAt(0) - '0';
					
					count--; // count depleting for wrong input from user
				}
				
				if (option == 1) {
					// option == 1 for login module
					System.out.println("\nYou opted for login");
					new LoginModule();
					
				}else if(option == 2) {
					// option == 2 for sign up module
					System.out.println("\nYou opted for signup");
					SignupModule.signUp();
					
				}else {
					// option == 3 for Exit
					System.out.println("\nExiting from the application");
					flag = false; // exit
				}
			}
			
			System.out.println("\nThank you for using Hotelo....");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
