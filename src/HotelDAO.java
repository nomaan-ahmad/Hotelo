import java.sql.*;

public class HotelDAO {
	private final Connection con;
	HotelDAO() {
		con = DBConnection.connect();
	}
	
	// feature to print hotels filtered by city
	public boolean availableByCity(String city) {
		System.out.println("Please wait! We are searching for your room..");
		boolean flag = false;
		String query = "select hotelID, hotelName, stars from hotels where city = ? and bookingStatus = 0";
		try(PreparedStatement pt = con.prepareStatement(query)) {
			pt.setString(1, city);
			ResultSet rs = pt.executeQuery();
			if (!rs.next()) return flag;
			
			flag = true;
			System.out.println("Rooms available");
			
			do {
				int id = rs.getInt(1);
				String hotelName = rs.getString(2);
				int stars = rs.getInt(3);
				
				System.out.println("-> " + id + " " + hotelName + " " + stars + "-stars");
			} while(rs.next());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// feature to print hotels filtered by city and stars
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
