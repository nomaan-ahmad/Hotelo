package com.Hotelo.feature.login;

import com.Hotelo.authentication.Credential;
import com.Hotelo.userInput.Menu;
import com.Hotelo.authentication.Authentication;
import com.Hotelo.userInput.Response;

import java.util.Scanner;

public class LoginModule {
	public static void login() {
		Response<Credential> response = helper();
		if (response.status) {
			System.out.println("Login Successful");

			// After logging in successfully, Menu will pop up
			new Menu(response.response);

		}else {
			System.out.println("\nLogin unsuccessful. Please try again later");
			System.out.println("Make sure you already have account before logging in");
		}
	}

	private static Response<Credential> helper() {
		int count = 3;
		Scanner in = new Scanner(System.in);
		while (count > 0) {
			System.out.println("\nusername: ");
			String username = in.nextLine();
			System.out.println("password: ");
			String password = in.nextLine();

			boolean flag = Authentication.authorize(username, password);

			if (!flag) System.out.println("Try again -> " + count +" chances left");
			else return new Response<>(true, new Credential(username, password));
			count--;
		}
		return new Response<>(false, null);
	}
}
