package com.Hotelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Customer {
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String mobileNo;
	private String password;
	
	public Customer() {}

	public void askDetails() {
		System.out.println("We will ask few information before proceeding.");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("First name ?");
			fName = br.readLine();
			System.out.println("Last name?");
			lName = br.readLine();
			System.out.println("email ID :");
			email = br.readLine();
			System.out.println("Mobile number :");
			mobileNo = br.readLine();
			System.out.println("Set a good password");
			password = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}

	public String getFName() {
		return fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public String getPassword() {
		return password;
	}
	
//	public boolean addCustomer(){
//		System.out.println("Please wait!! Signing up");
//		boolean flag = false;
//		CustomerDAO c = new CustomerDAO(this);
//		flag = c.addCustomer();
//		return flag;
//	}
}
