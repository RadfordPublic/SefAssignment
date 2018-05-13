public class Course {
	private String courseName;
	private String courseCode;
	private String coordinators;
	private String teachers;
	private Discipline discipline;
	
	public enum Discipline {
		SCIENCE, ARTS, SCIENCEJR, ARTSJR, SCIENCESR, ARTSSR 
	}
	
	public Course(String courseName, Discipline disc, String courseCode) {
		this.setCourseName(courseName);
		this.setDiscipline(disc);
		this.setCourseCode(courseCode);
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCoordinators() {
		return coordinators;
	}
	public void setCoordinators(String coordinators) {
		this.coordinators = coordinators;
	}
	public String getTeachers() {
		return teachers;
	}
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
	public Discipline getDiscipline() {
		return discipline;
	}
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

}
