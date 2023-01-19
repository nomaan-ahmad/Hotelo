import java.sql.*;

public class CustomerDAO {
	private Customer customer;
	Connection con;
	public CustomerDAO() {
		try {
			if (con == null) con = DBConnection.connect();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public CustomerDAO(Customer customer) {
		this.customer = customer;
		try {
			con = DBConnection.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyCustomer(String email, String password) {
		String query = "select first_name, last_name from customer where email = ? and password = ?";
		try (PreparedStatement pt = con.prepareStatement(query)) {
			pt.setString(1, email);
			pt.setString(2, password);
			
			ResultSet rs = pt.executeQuery();
			if (rs.next()) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addCustomer() {
		boolean flag = false;
		String query = "insert into customer(email, first_name, last_name, mobile_no, password) values(?,?,?,?,?)";
		try (PreparedStatement p = con.prepareStatement(query)) {
			p.setString(1, customer.getEmail());
			p.setString(2, customer.getFName());
			p.setString(3, customer.getLName());
			p.setString(4, customer.getMobileNo());
			p.setString(5, customer.getPassword());
			
			p.execute();
			flag = true;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
