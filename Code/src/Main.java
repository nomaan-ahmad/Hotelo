import java.io.*;

public class Main {
	private static boolean signIn() {
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
			
			Customer customer = new Customer(firstName, lastName, email, mobile);
			flag = customer.addCustomer();
			if (flag) System.out.println("Customer added successfully...");
			else System.out.println("Something unexpected happened...");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args) {
		System.out.println("Welcome to HOTELO!.....");
		
		System.out.println("\n-------------------------------------\n");
		
	}
}
