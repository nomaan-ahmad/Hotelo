package com.Hotelo;
import java.sql.*;

public class CustomerDAO {
	Connection con;
	public CustomerDAO() {
		try {
			con = DBConnection.connect();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// working fine
	public boolean verifyCustomer(String email, String password) {
		String query = "select first_name, last_name from customers where email = ? and password = ?";
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
	
	public boolean addCustomer(Customer cus) {
		boolean flag = false;
		String query = "insert into customers(email, first_name, last_name, mobile_no, password) values(?,?,?,?,?)";
		try (PreparedStatement p = con.prepareStatement(query)) {
			p.setString(1, cus.getEmail());
			p.setString(2, cus.getFName());
			p.setString(3, cus.getLName());
			p.setString(4, cus.getMobileNo());
			p.setString(5, cus.getPassword());
			
			p.execute();
			flag = true;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
