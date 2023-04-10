package com.Hotelo.model;

import java.util.Date;

public class BookingEntry {
    private int bookingID;
    private int roomID;
    private String hotelName;
    private String customerEmail;
    private Date checkIn;
    private String roomType;
    private String city;

    public BookingEntry () {}

    public BookingEntry(int bookingID, int roomID, String hotelName, String customerEmail, Date checkIn, String roomType, String city) {
        this.bookingID = bookingID;
        this.roomID = roomID;
        this.hotelName = hotelName;
        this.customerEmail = customerEmail;
        this.checkIn = checkIn;
        this.roomType = roomType;
        this.city = city;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "BookingEntry{" +
                "bookingID=" + bookingID +
                ", roomID=" + roomID +
                ", hotelName='" + hotelName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", checkIn=" + checkIn +
                ", roomType='" + roomType + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
