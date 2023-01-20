
public class Hotel {
	public static boolean bookHotel(Credential cred) {
		boolean flag = false;
		System.out.println("Welcome to hotel booking portal..");
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//			String city = null;
//			boolean loop1 = true;
//			int count1 = 0;
//			while(!flag && loop1 && count1 < 2) {
//				System.out.println("In which City you are planning to stay?");
//				city = br.readLine();
//				flag = new HotelDAO().availableByCity(city);
//				if (flag == false) {
//					System.out.println("Sorry no room availables for the input city :(");
//					boolean loop2 = true;
//					int count2 = 0;
//					System.out.println("Do you want to search again?");
//					while (loop2 && count2 < 3) {
//						System.out.println("Press y/n");
//						Character ch = br.readLine().toLowerCase().charAt(0);
//						if (ch == 'y' || ch == 'n') {
//							loop2 = false;
//							if(ch == 'n') loop1 = false;
//						}else System.out.println("kindly type 'y' or 'n' and nothing else :)");
//						
//						count2++;
//					}
//					
//				}
//				count1++;
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		return flag;
	}
	
	public static void presentBooking(Credential cred) {
		System.out.println("Your present booking");
	}
	
	public static void pastBooking(Credential cred) {
		System.out.println("Your past booking");
	}
	
	public static void checkout(Credential cred) {
		System.out.println("Check out portal");
	}
}
