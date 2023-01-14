import java.sql.Connection;
import java.sql.*;

public class CustomerDAO {
	private Customer customer;
	Connection con;
	public CustomerDAO(Customer customer) {
		this.customer = customer;
		try {
			con = DBConnection.connect();
			String query = "insert into customer('email', 'fName', 'lName', 'mobileNo') values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString(3) + rs.getString(4);
				String email = rs.getString(2);
				System.out.println("name: " + name + "\nemail: " + email);
				
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
