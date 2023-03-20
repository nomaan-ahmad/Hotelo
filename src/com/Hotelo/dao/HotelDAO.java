package com.Hotelo.dao;

import com.Hotelo.connection.DBConnection;
import com.Hotelo.model.Hotels;
import com.Hotelo.model.Rooms;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HotelDAO {
	private final Connection con;
	public HotelDAO() {
		con = DBConnection.connect();
	}

	/* ****************************** ---------- ******************************* */

	// Room types in hotel which are yet not booked [*]
	public List<Rooms> roomsTypeAvailable(int hotelID) {
		List<Rooms> rooms = new ArrayList<>();
		/*
			This method will get roomID and room type in hotel whose hotelID is input
			and which is yet not booked

			This method will return always return list with at least size: 1 because
			of the way we are calling it
		 */
		String query = "select roomID, type from rooms " +
				"inner join hotels on rooms.hotelID = hotels.hotelID " +
				"where booked = 0 and hotels.hotelID = ?;";

		try (PreparedStatement pr = con.prepareStatement(query)) {
			pr.setInt(1, hotelID);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Rooms room = new Rooms();
				room.setRoomID(rs.getInt(1));
				room.setType(rs.getString(2));

				rooms.add(room);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// returning roomID with type of room in a hotel which is yet not booked
		return rooms;
	}

	/* ****************************** ---------- ******************************* */

	// List of all cities where hotelo is operating [*]
	public HashSet<String> allCities() {
		// this method is to get all cities where the hotel merchants are operating
		HashSet<String> cities = new HashSet<>();

		// sql query statement
		String query = "select distinct city from hotels";
		try (Statement st = con.createStatement()) {

			// storing results in result set
			ResultSet rs = st.executeQuery(query);

			// adding all results in hashset to return
			while (rs.next()) {
				cities.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// returning
		return cities;
	}

	/* ****************************** ---------- ******************************* */

	// Cities available to book a room [*]
	public HashSet<String> availableCity() {
		HashSet<String> cities = new HashSet<>();
		/*
			Below query will get all the cities where rooms are not booked
			So that user can choose from it

			This method will return all the cities with the above condition
		 */

		// query
		String query = "select distinct city from hotels " +
				"inner join rooms on hotels.hotelID = rooms.hotelID " +
				"where booked = 0";

		try (Statement pr = con.createStatement()) {
			ResultSet rs = pr.executeQuery(query);

			while (rs.next()) {
				cities.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}

	/* ****************************** ---------- ******************************* */

	// Hotels available in selected city [*]
	public List<Hotels> hotelsAvailableInCity(String city) {
		/*
			This method will return all the hotels in the input cities
			where a user can choose to stay

			HashSet in this method will always have some values in it
			because we are calling it in such a way
		 */
		List<Hotels> hotels = new ArrayList<>();

		String query = "select distinct hotels.hotelID, hotelName from hotels " +
				"inner join rooms on hotels.hotelID = rooms.hotelID " +
				"where booked = 0 and city = ?";

		try (PreparedStatement pr = con.prepareStatement(query)) {
			// setting the parameter of query
			pr.setString(1, city);

			// getting the result
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {

				// creating hotel object
				Hotels hotel = new Hotels();
				hotel.setHotelID(rs.getInt(1));
				hotel.setHotelName(rs.getString(2));

				// adding hotel to hotels hashset to return
				hotels.add(hotel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// returning the hotels with the above stated conditions
		return hotels;
	}

	/* ****************************** ---------- ******************************* */

	// Book hotel feature [*]
	public boolean bookRoom(int roomID, String email, String checkIn) {
		String query1 = "insert into currentbooking(roomID, email, checkIn) values("
				+ "'" + roomID + "'" + ',' + "'" + email + "'" + ',' + "'" + checkIn + "'" + ")";

		String query2 = "update rooms set booked=1 where roomID=" + roomID;
		try(Statement st = con.createStatement()) {
			int result = st.executeUpdate(query1);
			st.executeUpdate(query2);

			return result > 0;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* ****************************** ---------- ******************************* */

	// feature to print hotels filtered by city and stars []
	public boolean availableByCityAndStars(String city, int stars) {
		boolean flag = false;
		String query = "select hotelID, hotelName, city from hotels where city = ? and stars = ? and bookingStatus = 0";
		try(PreparedStatement pt = con.prepareStatement(query)) {

			// filling arguments of prepare statement
			pt.setString(1, city);
			pt.setInt(2, stars);

			// executing the statement
			ResultSet rs = pt.executeQuery();

			// if null means no hotels available
			if (rs == null) return flag;

			// rooms are available for selected city and stars
			flag = true;
			System.out.println("Rooms available");
			while(rs.next()) {
				int id = rs.getInt(1);
				String hotelName = rs.getString(2);

				System.out.println("-> " + id + " " + hotelName);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
