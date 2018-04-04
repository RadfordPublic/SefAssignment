package assignment; 
public class User {
	private String employeeID;
	private String name;
	private int phone;
	private String email;
	
	public User(String employeeID, String name, int phone, String email) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getName() {
		return name;
	}

	public int getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
	
	

	
	

}
