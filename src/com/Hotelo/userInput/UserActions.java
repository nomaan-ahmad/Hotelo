package com.Hotelo.userInput;

import com.Hotelo.authentication.Credential;
import com.Hotelo.dao.HotelDAO;
import com.Hotelo.feature.booking.HotelBooking;

public class UserActions {
	// Hotel booking feature [*]
	public static void bookHotel(Credential cred) {
		System.out.println("""
				Welcome to Hotel booking portal!!
				We are in multiple cities. List is as follows :
				""");

		// Printing all cities where Hotelo is operating
		System.out.println(new HotelDAO().allCities());

		// Starting Hotel booking process
		HotelBooking hb = new HotelBooking(cred);

		// Taking input for the city
		Response<String> city = hb.citySelection();
		if (!city.status) {
			System.out.println("You didn't select city to proceed further. Exiting...");
			System.out.println("Thank you for using our booking portal");
			return;
		}

		// Taking input for the hotel
		Response<Integer> hotel = hb.hotelSelection(city.response);
		if (!hotel.status) {
			System.out.println("You didn't select hotel to proceed further. Exiting...");
			System.out.println("Thank you for using our booking portal");
			return;
		}

		// Taking input for the room type
		Response<Integer> room = hb.roomTypeSelection(hotel.response);
		if (!room.status) {
			System.out.println("You didn't select room to proceed further. Exiting...");
			System.out.println("Thank you for using our booking portal");
			return;
		}

		boolean booked = hb.bookRoom(room.response);
		if (booked) {
			System.out.println("""
					You can check your booking from Present booking portal""");
		}
		else System.out.println("Unfortunately, hotel is not booked. Please try again");

	}
	
	public static void presentBooking(Credential cred) {
		System.out.println("Your present booking");
	}
	
	public static void pastBooking(Credential cred) {
		System.out.println("Your past booking");
	}
	
	public static void checkout(Credential cred) {
		System.out.println("Check out portal");
	}
}
