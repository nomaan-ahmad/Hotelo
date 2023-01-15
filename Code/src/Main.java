import java.io.*;

public class Main {
	
	// signup feature
	private static boolean signUp() {
		boolean flag = false;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Every detail is mandatory to fill..");
			System.out.println("What is your first name ?");
			String firstName = br.readLine();
			System.out.println("What is your last name ?");
			String lastName = br.readLine();
			System.out.println("Your email address ?");
			String email = br.readLine();
			System.out.println("Your mobile number ?");
			String mobile = br.readLine();
			
			// setting password
			System.out.println("Set a good password for your account (length >= 8)");
			String password = br.readLine();
			
			// password length should be greater than 8
			while (password.length() < 8) {
				System.out.println("password is too weak, increase its length");
				password = br.readLine();
			}
			
			// creating customer object
			Customer customer = new Customer(firstName, lastName, email, mobile, password);
			
			// using customer object adding them to database
			flag = customer.addCustomer();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	// login feature
	private static boolean login() {
		System.out.println("Login Screen..");
		boolean flag = false;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("Email: ");
			String email = br.readLine();

			System.out.print("Password: ");
			String password = br.readLine();
			
			// creating customer object
			Customer customer = new Customer(email, password);
			// using customer object to verify the user
			flag = customer.verifyCustomer();
			
			int count = 0; // count variable to limit number of time login attempt
			boolean signup = false; // if user opted to choose signup because of lack of credentials
			while (!flag && !signup && count < 5) {
				System.out.println("Wrong email or password");
				System.out.println("Press 1 for retry or Press 2 for SignUp");
				
				try {
					int choice = br.read();
					
					// choice 49 means user pressed '1'. ASCII CODE of 1 is 49
					if (choice == 49) {
						// using readLine() because without it read() method is not skipping the line
						br.readLine();
						System.out.print("Email: ");
						email = br.readLine();

						System.out.print("Password: ");
						password = br.readLine();

						
						customer = new Customer(email, password); // creating customer object
						flag = customer.verifyCustomer(); // using customer object verifying
						
						// choice 50 means user pressed 2. ASCII CODE of 2 is 50
					} else if (choice == 50) {
						// using readLine() because without it read() method is not skipping the line
						br.readLine();
						signup = signUp();
					} else {
						br.readLine();
						if(count < 4) System.out.println("select correct choice..."); // if user choose any character apart from 1 or 2
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				count++;
			}
			
			// if signup == true which means user created their account not logged in
			if(signup) System.out.println("Account successfully created... Now you can login using your credentials");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args) {
		System.out.println("Welcome to HOTELO!.....");
		
		System.out.println("\n-------------------------------------\n");
		
		if (login()) System.out.println("login successfully");
	}
}
