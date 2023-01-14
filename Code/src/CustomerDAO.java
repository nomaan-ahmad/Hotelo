import java.sql.*;

public class CustomerDAO {
	private Customer customer;
	Connection con;
	public CustomerDAO(Customer customer) {
		this.customer = customer;
		try {
			con = DBConnection.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addCustomer() {
		boolean flag = false;
		String query = "insert into customer(email, first_name, last_name, mobile_no) values(?,?,?,?)";
		try (PreparedStatement p = con.prepareStatement(query)) {
			p.setString(1, customer.getEmail());
			p.setString(2, customer.getFName());
			p.setString(3, customer.getLName());
			p.setString(4, customer.getMobileNo());
			
			p.execute();
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
