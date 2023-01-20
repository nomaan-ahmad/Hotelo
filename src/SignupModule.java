
public class SignupModule {
	public static void signUp() {
		Customer cus = new Customer();
		cus.askDetails();
		System.out.println("We are saving your details. Please wait...");
		boolean flag = new CustomerDAO().addCustomer(cus);
		
		if (flag) System.out.println("Wohoo! Account made successfully...");
		else System.out.println("Oops! Some error occured :(");
	}
}
