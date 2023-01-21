package com.Hotelo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HotelBooking {
    // make it modular you bitch
    private Credential customer;
    HotelBooking(Credential cred) {
        customer = cred;
        System.out.println("Welcome to hotel booking portal..");

        System.out.println("In which city are you planning to say?");
        String city = Input.line();

        HashSet<Integer> hotels = new HotelDAO().availableByCity(city);
        if (hotels.size() == 0) System.out.println("No rooms available");

        boolean loop = true;
        while (loop) {
            System.out.println("Sorry! No hotels available for input city.");
            System.out.println("Do you want to search for different city ?");

            char ch = Input.yesOrNo();
            if (ch == 'y') {
                city = Input.line();

                hotels = new HotelDAO().availableByCity(city);
            } else loop = false;
        }

        if (hotels.size() > 0) {
            System.out.println("Please type hotelID in order to " +
                    "proceed with hotel booking or enter 'X' to exit");

            while (true) {
                boolean flag = true;
                String input = Input.line();
                if (input.toLowerCase().charAt(0) == 'x') break;
                if (hotels.contains(Integer.valueOf(input))) {
                    int hotelID = Integer.parseInt(input);
                    //Response<String> roomType = roomTypeAvailable(hotelID);
                    //if (!roomType.status) break;

                }else {
                    System.out.println("Kindly enter hotelID " +
                            "from the above available hotel list");
                }
            }
        }

        System.out.println("Thank you from Hotel Booking portal");
    }



    // city selection is implemented [*]
    private Response<String> citySelection() {
        HashSet<String> cities = new HotelDAO().allCities();
        System.out.println("In which city are you planning to say?");
        String city = Input.line();

        while (!cities.contains(city)) {
            System.out.println("We are not currently operating in " + city + " :(");
            System.out.println("Enter different city to proceed, or enter 'X' to exit");
            city = Input.line();
            if (city.toLowerCase().charAt(0) == 'x') return new Response<>(false, null);
        }
        return new Response<>(true, city);
    }

    private void hotelSelection(String city){
        // this method is to select which hotel user want to stay in the selected city
    }
    private void roomTypeAvailable(int hotelID) {

        System.out.println("Enter which type of room you want to relax");

        List<Rooms> rooms = new HotelDAO().roomsTypeAvailable(hotelID);
        List<Integer> roomID = new ArrayList<>();

        for (Rooms r : rooms) roomID.add(r.getRoomID());

        String choice = Input.line();


    }

    private void bookRoom() {

    }
}
