package com.Hotelo;
import java.sql.*;

public class DBConnection {
	public static Connection connect() {
		Connection con = null;
		String user = "root";
		String password = "toor";
		String url = "jdbc:mysql://localhost:3306/Hotelo";
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection established...");
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
