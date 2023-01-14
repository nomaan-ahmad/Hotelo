import java.io.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to HOTELO!.....");
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Tell me your first name");
			String firstName = br.readLine();
			System.out.println("Tell me your last name");
			String lastName = br.readLine();
			System.out.println("Tell me your email");
			String email = br.readLine();
			System.out.println("Tell me your mobile number");
			String mobile = br.readLine();
			
			Customer customer = new Customer(firstName, lastName, email, mobile);
			if (customer.addCustomer()) System.out.println("customer added successfully");
			else System.out.println("Something unexpected happened");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
