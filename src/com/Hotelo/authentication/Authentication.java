package com.Hotelo.authentication;

import com.Hotelo.dao.CustomerDAO;

public class Authentication {
	public static boolean authorize(String username, String password) {
		// authentication module to verify the credentials of customer by calling Customer DAO class
		// and to apply necessary operation on username or password before sending it Database
		System.out.println("We are verifying your credentials\nPlease wait....");
		return (new CustomerDAO().verifyCustomer(username.toLowerCase(), password));
	}
}
