
public class Classwork{
	
	private static String day;
	private String roomNo;
	private String teacher;
	private String classtype;
	private String course;
	
	
	public Classwork(String day, String roomNo, String teacher, String classtype, String course) {
		this.setDay(day);
		this.setRoomNo(roomNo);
		this.setTeacher(teacher);
		this.setClasstype(classtype);
		this.setCourse(course);
	}

	public static String getDay() {
		return day;
	}

	public void setDay(String day) {
		Classwork.day = day;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String toString() {
		return "Course: "+getCourse()+" Class: "+getClasstype()+" Day: "+getDay()+" Room: "+getRoomNo()+" Teacher: "+getTeacher();
		
	}

}
