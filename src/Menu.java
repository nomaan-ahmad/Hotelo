import java.util.Scanner;

public class Menu {
	public Menu(Credential _cred) {
		System.out.println("Dashboard");
		
		boolean flag = true;
		
		while (flag) {
			int option = options();

			switch (option) {
				case 1 -> Hotel.bookHotel(_cred);
				case 2 -> Hotel.presentBooking(_cred);
				case 3 -> Hotel.pastBooking(_cred);
				case 4 -> Hotel.checkout(_cred);
				case 5 -> flag = false;
				default -> System.out.println("Kindly select correct option");
			}
		}
		
		System.out.println("Thank you for using our service.");
	}
	
	private int options() {
		Scanner in = new Scanner(System.in);

		System.out.println("Select options (between 1 to 5)");
		System.out.println("1. Book a hotel\n2. Present Bookings\n3. Past Bookings\n4. Checkout\n5. Exit\n");

		return in.nextLine().charAt(0) - '0';
	}
	
}
