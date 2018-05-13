
public class User {
	
	public enum UserType {
		ADMINISTRATOR, APPROVALS, CASUALSTAFF, COORDINATOR, UNASSIGNED	
	}
	
	private String username;
	private String password;
	private UserType userType;
	@SuppressWarnings("unused")
	private String application;
	
	public User(String string, String string2, String type, String phone, String email) {
		this.setUsername(string);
		this.setPassword(string2);
		this.setUserType(getUserType(type));
	}

	public UserType getUserType(String name) {
		if (name.equalsIgnoreCase("administrator")) {
			return UserType.ADMINISTRATOR;
		}
		else if (name.equalsIgnoreCase("approvals")) {
			return UserType.APPROVALS;
		}
		else if (name.equalsIgnoreCase("casualstaff")) {
			return UserType.CASUALSTAFF;
		}
		else if (name.equalsIgnoreCase("coordinator")) {
			return UserType.COORDINATOR;
		}
		else {
			return UserType.UNASSIGNED;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getApplication() {
		return Helper.FILLER;
	}

	public void setApplication(String application) {
		this.application = application;
	}

}
