package com.Hotelo.model;

public class Rooms {
    private int roomID;
    private int hotelID;
    private String type;
    private boolean booked;

    /* ******************** Getters **************************** */

    public int getRoomID() {
        return roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getType() {
        return type;
    }

    public boolean isBooked() {
        return booked;
    }

    /* ***************************** Setters ****************************** */

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
