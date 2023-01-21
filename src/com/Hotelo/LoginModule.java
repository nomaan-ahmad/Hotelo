package com.Hotelo;

import com.Hotelo.Authentication;

import java.util.Scanner;

public class LoginModule {
	private static class Pair {
		boolean flag;
		Credential cred;
		public Pair(boolean _flag, Credential _cred) {
			flag = _flag;
			cred = _cred;
		}
	}
	public LoginModule() {
		Pair response = login();
		if (response.flag) {
			System.out.println("Login Successful");
			
			// After logging in successfully, Menu will pop up
			new Menu(response.cred);
			
		}else {
			System.out.println("\nLogin unsuccessful. Please try again later");
			System.out.println("Make sure you already have account before logging in");
		}
		
	}
	private Pair login() {
		int count = 3;
		Scanner in = new Scanner(System.in);
		while (count > 0) {
			System.out.println("\nusername: ");
			String username = in.nextLine();
			System.out.println("password: ");
			String password = in.nextLine();

			boolean flag = Authentication.authorize(username, password);

			if (!flag) System.out.println("Try again -> " + count +" chances left");
			else return new Pair(true, new Credential(username, password));
			count--;
		}
		return new Pair(false, null);
	}
}
