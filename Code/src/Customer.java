
public class Customer {
	private static int id;
	private String fName;
	private String lName;
	private String email;
	private String mobileNo;
	
	public Customer() {};
	public Customer(String _fName, String _lName, String _email, String _mobileNo) {
		fName = _fName;
		lName = _lName;
		email = _email;
		mobileNo = _mobileNo;
	}
	
	public String getName() {
		return fName + " " + lName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public boolean addCustomer(){
		boolean flag = false;
		
		return flag;
	}
}
