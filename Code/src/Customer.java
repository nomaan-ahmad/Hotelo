
public class Customer {
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String mobileNo;
	
	public Customer(String _fName, String _lName, String _email, String _mobileNo) {
		fName = _fName;
		lName = _lName;
		email = _email;
		mobileNo = _mobileNo;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return fName + " " + lName;
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
	
	public boolean addCustomer(){
		System.out.println("Please wait!! Signing up");
		boolean flag = false;
		CustomerDAO c = new CustomerDAO(this);
		flag = c.addCustomer();
		return flag;
	}
}
