package com.Hotelo.main;
import com.Hotelo.feature.login.LoginModule;
import com.Hotelo.feature.signup.SignupModule;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to HOTELO!.....");
		System.out.println("\n-------------------------------------");
		System.out.println("You want to login? If new user press 2 for sign up");
		/*
		 * 1. Login
		 * 2. SignUp
		 * 3. Exit
		 */

		Scanner in = new Scanner(System.in);

		boolean flag = true;

		// there are 2 ways to exit from this loop, either user opted (i.e option == 3)
		// or user chose wrong option 3 times

		while (flag) {
			System.out.println("\nChoose options\n1. Login\n2. Signup\n3. Exit");
			int option = in.nextLine().charAt(0) - '0';
			int count = 3;
			while(count > 0 && !(option == 1 || option == 2 || option == 3)) {
				System.out.println("\nTry again and choose correct options)");
				System.out.println("1. Login\n2. Signup\n3. EXIT");
				option = in.nextLine().charAt(0) - '0';

				count--; // count depleting for wrong input from user
			}

			if (option == 1) {
				// option == 1 for login module
				System.out.println("\nYou opted for login");
				LoginModule.login();

			}else if(option == 2) {
				// option == 2 for sign up module
				System.out.println("\nYou opted for signup");
				SignupModule.signUp();

			}else {
				// option == 3 for Exit
				System.out.println("\nExiting from the application");
				flag = false; // exit
			}
		}
		System.out.println("\nThank you for using Hotelo....");
	}
}
