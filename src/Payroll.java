
public class Payroll {
	private String total;
	private User user;

	public Payroll(String total, User user) {
		this.setUser(user);
		this.setTotal(total);
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
