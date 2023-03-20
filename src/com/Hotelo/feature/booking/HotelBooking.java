package com.Hotelo.feature.booking;

import com.Hotelo.authentication.Credential;
import com.Hotelo.userInput.Input;
import com.Hotelo.userInput.Response;
import com.Hotelo.dao.HotelDAO;
import com.Hotelo.model.Hotels;
import com.Hotelo.model.Rooms;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

public class HotelBooking {
    // make it modular
    private final Credential customer;
    public HotelBooking(Credential cred) {
        customer = cred;
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

    // Room type selection [*]
    public Response<Integer> roomTypeSelection(int hotelID) {
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

    // Booking feature [*]
    public boolean bookRoom(int roomID) {
        System.out.println("Booking process initialised");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        String dateTime = dtf.format(zdt);

        if(new HotelDAO().bookRoom(roomID, customer.email, dateTime)){
            System.out.println("Booked successfully");
            return true;
        }else System.out.println("Something unexpected happened");

        return false;
    }
}
