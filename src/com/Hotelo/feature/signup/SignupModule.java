package com.Hotelo.feature.signup;

import com.Hotelo.model.Customer;
import com.Hotelo.dao.CustomerDAO;

public class SignupModule {
	public static void signUp() {
		Customer cus = new Customer();
		cus.askDetails();
		System.out.println("We are saving your details. Please wait...");
		boolean flag = new CustomerDAO().addCustomer(cus);
		
		if (flag) System.out.println("Wohooo! Account made successfully...");
		else System.err.println("Oops! Some error occurred :(");
	}
}
