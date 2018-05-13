public class TimeSheet {
	private String user;
	private String time;
	private String rate;
	private String className;
	private String course;

	public TimeSheet(String user, String course, String className, String time , String rate) {
		this.setUser(user);
		this.setTime(time);
		this.setRate(rate);
		this.setClassName(className);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
