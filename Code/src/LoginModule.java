import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginModule {
	public LoginModule() {
		boolean flag = login();
		if (flag) {
			System.out.println("Login Successful");
			System.out.println("Menu");
		}else {
			System.out.println("Login unsuccesful. Please try again later");
			System.out.println("Make sure you already have account before logging in");
		}
		
	}
	
	private boolean login() {
		boolean flag = false; // I am using flag to get if login was successfully done or not
		int count = 3;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (count > 0 && !flag) {
				System.out.println("username: ");
				String username = br.readLine();
				System.out.println("password: ");
				String password = br.readLine();
				
				flag = Authentication.authorize(username, password);
				
				if (!flag)
					System.out.println("Try again :) | " + count +" chances left");
				
				count--;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
