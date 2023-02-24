package com.Hotelo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class HotelBooking {
    // make it modular
    private Credential customer;
    HotelBooking(Credential cred) {
        customer = cred;
        System.out.println("Welcome to hotel booking portal..");

        System.out.println("In which city are you planning to say?");
        String city = Input.line();

        HashSet<Integer> hotels = new HotelDAO().availableByCity(city);
        if (hotels.size() == 0) System.out.println("No rooms available");

        boolean loop = true;
        while (loop && hotels.size() == 0) {
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
    public Response<String> citySelection() {
        HashSet<String> cities = new HotelDAO().availableCity();
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

    // Hotel selection is implemented [*]
    public Response<Integer> hotelSelection(String city){
        Scanner sc = new Scanner(System.in);
        // this method is to select which hotel user want to stay in the selected city
        List<Hotels> allHotel = new HotelDAO().hotelsAvailableInCity(city);
        HashSet<Integer> allHotelID = new HashSet<>();
        for (Hotels h : allHotel) allHotelID.add(h.getHotelID());

        // Printing all available hotels in selected city
        System.out.println("All available hotels in " + city + " are as follows :");
        System.out.println(allHotel);

        // taking input from the user
        System.out.println("Kindly select the hotels by typing corresponding HotelID");
        boolean flag = false;
        int hotelID = -1;
        while (!flag) {
            try {
                String input = Input.line().trim();
                if (input.toLowerCase().charAt(0) == 'x') {
                    flag = true;
                    return new Response<>(false, null);
                }
                hotelID = Integer.parseInt(input);
                if (allHotelID.contains(hotelID)) flag = true;
                else System.out.println("Type correct HotelID");
            } catch (NumberFormatException e) {
                if (flag) break;
                System.out.println("Wrong input format");
                System.out.println("Try again");
            }
        }

        return new Response<>(true, hotelID);
    }

    // Room type selection []
    private Response<Integer> roomTypeSelection(int hotelID) {
        System.out.println("Select the room you want to relax in :)");

        List<Rooms> rooms = new HotelDAO().roomsTypeAvailable(hotelID);
        HashSet<Integer> roomIDs = new HashSet<>();

        System.out.println("Room ID | Room Type");
        for (Rooms r : rooms) {
            System.out.println(r.getRoomID() + " " + r.getType());
            roomIDs.add(r.getRoomID());
        }

        boolean flag = false;
        int roomID = -1;
        while (!flag) {
            try {
                System.out.println("Select room by typing its RoomID");
                String choice = Input.line();
                if (choice.toLowerCase().charAt(0) == 'x') {
                    flag = true;
                    return new Response<>(false, null);
                }
                roomID = Integer.parseInt(choice);
                if (roomIDs.contains(roomID)) flag = true;
                else {
                    System.out.println("kindly, select correct room ID");
                    System.out.println("If you want to exit, then type 'X'");
                }
            } catch (Exception e) {
                System.out.println("Please don't type anything than room ID");
                System.out.println("If you want to exit, then type 'X'");
            }
        }

        return new Response<>(true, roomID);
    }

    private void bookRoom() {

    }
}
