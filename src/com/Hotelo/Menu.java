package com.Hotelo;

public class Menu {
	Credential cred;
	public Menu(Credential _cred) {
		System.out.println("\n--------------------Dashboard--------------------");
		cred = _cred;
		options();
	}
	
	private void options() {
		boolean flag = true;
		while (flag) {
			System.out.println("\nSelect options (between 1 to 5)");
			System.out.println("1. Book a hotel\n2. Present Bookings\n3. Past Bookings\n4. Checkout\n5. Exit\n");
			int option = Input.singleChar() - '0';
			switch (option) {
				case 1 -> UserActions.bookHotel(cred);
				case 2 -> UserActions.presentBooking(cred);
				case 3 -> UserActions.pastBooking(cred);
				case 4 -> UserActions.checkout(cred);
				case 5 -> flag = false;
				default -> System.out.println("Kindly select correct option");
			}
		}

		System.out.println("Thank you for using our service.");
	}
}
