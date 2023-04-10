package com.Hotelo.dao;

import com.Hotelo.connection.DBConnection;
import com.Hotelo.model.BookingEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private final Connection con;
    public BookingDAO() { con = DBConnection.connect();}

    /*
    select b.bookingID, b.roomID, r.hotelName, r.type, r.city, b.email, b.checkIn from currentBooking b, (select roomID, type, hotelName, city from rooms r, hotels h where r.hotelID = h.hotelID) r where b.roomID = r.roomID and email = 'akanshacode@gmail.com'
    */
    public List<BookingEntry> currentBooking (String email) {
        List<BookingEntry> allBooking = new ArrayList<>();

        String query = "select b.bookingID, b.roomID, r.hotelName, r.type, r.city, b.email, b.checkIn from currentBooking b," +
                "(select roomID, type, hotelName, city from rooms, hotel where rooms.hotelID = hotels.hotelID) r" +
                "where b.roomID = r.roomID and email = ?";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                BookingEntry booking = new BookingEntry();
                booking.setBookingID(rs.getInt(1));
                booking.setRoomID(rs.getInt(2));
                booking.setHotelName(rs.getString(3));
                booking.setRoomType(rs.getString(4));
                booking.setCity(rs.getString(5));
                booking.setCustomerEmail(rs.getString(6));
                booking.setCheckIn(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(7)));

                allBooking.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allBooking;
    }
}
