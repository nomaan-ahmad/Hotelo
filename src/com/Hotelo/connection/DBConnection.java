package com.Hotelo.connection;
import java.sql.*;

public class DBConnection {
	private static Connection con;
	public static Connection connect() {
		if (con != null) return con;
		String user = "root";
		String password = "toor";
		String url = "jdbc:mysql://localhost:3306/Hotelo";
		try {
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			System.out.println("Some unexpected error occurred...");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void disconnect(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
