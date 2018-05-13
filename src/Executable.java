import java.util.Scanner;

public class Executable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		User user = Helper.login(scanner);
		boolean loggedin = true;
		while (loggedin) {
			String response = Helper.setMenu(scanner, user);
			if(response.equalsIgnoreCase("AU")) {
				Helper.addUser(scanner);
			}
			if(response.equalsIgnoreCase("EU")) {
				Helper.editUser(scanner, user);
			}
			if(response.equalsIgnoreCase("SP")) {
				Helper.showProfile(scanner, user);
			}
			if(response.equalsIgnoreCase("SA")) {
				Helper.showAvailability(scanner, user);
			}
			if(response.equalsIgnoreCase("OT")) {
				Helper.openTimetable(scanner, user);
			}
			if(response.equalsIgnoreCase("ST")) {
				Helper.searchTeachers(scanner, user);
			}
			if(response.equalsIgnoreCase("VA")) {
				Helper.openStaffAppications(scanner, user);
			}
			if(response.equalsIgnoreCase("GR")) {
				Helper.generateReports(scanner, user);
			}
			if(response.equalsIgnoreCase("CS")) {
				Helper.createSemester(scanner, user);
			}
			if(response.equalsIgnoreCase("CC")) {
				Helper.createCourse(scanner, user);
			}
			if(response.equalsIgnoreCase("CD")) {
				Helper.createClassData(scanner, user);
			}
			if(response.equalsIgnoreCase("Q")) {
				user = Helper.logout(scanner);
			}
		}
	}

}
