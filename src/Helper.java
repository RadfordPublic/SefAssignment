import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Helper {
	final static String FILLER = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
	public static User login(Scanner scanner) {
		
		boolean flag = false;
		User user = null;
		ArrayList<List<String>> accounts = null;
		try {
			accounts = DataStore.getAccounts();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (flag== false) {
		System.out.println("Enter your Username");
		String username = scanner.next();
		System.out.println("Enter your Password");
		String password = scanner.next();
		
		for (List<String> account : accounts) {
			try {
			if (account.get(0).equalsIgnoreCase(username) && account.get(1).equalsIgnoreCase(password)) {
				user = new User(account.get(0),account.get(1),account.get(2), "Phone Number", "Email");
				flag = true;
			}
			}catch (Exception e){
				break;
			}
		}
		if(flag==false) {
			System.out.println("Login details incorrect please try again");
		}
		}
		System.out.println("Logging in ...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static String setMenu(Scanner scanner, User user) {
		System.out.println("_______________________________");
		System.out.println("Welcome "+ user.getUsername());
		System.out.println("Press code for one of the following");
		
		System.out.println("notifications: "+getNotiNumber());
		System.out.println("OT - Open Timetable");
		System.out.println("SP - Show Profile");
		
		if(user.getUserType().equals(User.UserType.ADMINISTRATOR)) {
			System.out.println("AU - Add User");
			System.out.println("EU - Edit User");
		}
		if(user.getUserType().equals(User.UserType.ADMINISTRATOR)
				||user.getUserType().equals(User.UserType.COORDINATOR)) {
			System.out.println("ST - Search Teachers");
			System.out.println("CS - Create Semester");
			System.out.println("CC - Create Course");
			System.out.println("CD - Create Class");
			System.out.println("VA - View/Approve Staff Applications");
		}
		if (user.getUserType().equals(User.UserType.APPROVALS)) {
			System.out.println("VA - View/Approve Staff Applications");
			System.out.println("GR - Generate Report");
		}
		if (user.getUserType().equals(User.UserType.CASUALSTAFF)) {
			System.out.println("SA - show availability");
			System.out.println("VA - View/Edit Application/resume");
		}
		if (user.getUserType().equals(User.UserType.UNASSIGNED)) {
			System.out.println("what are you doing without a role? contact system administrator");
		}
		System.out.println("Q - Logout");
		
		System.out.println("Enter your Response");
		String response = scanner.next();
		
		return response;
	}
	
	private static String getNotiNumber() {
		int number = 0;
		return Integer.toString(number);
	}

	public static void addUser(Scanner scanner) {
		System.out.println("Enter new Username");
		String username = scanner.next();
		System.out.println("Enter new Password");
		String password = scanner.next();
		System.out.println("Enter their type");
		String type = scanner.next();
		String line = username+" "+password+" "+type+",";
		try {
			DataStore.addCSV(line, "/src/logins.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void editUser(Scanner scanner, User user) {
		User userE = searchTeachers(scanner,user);
		System.out.println("Enter new Username");
		String username = scanner.next();
		System.out.println("Enter new Password");
		String password = scanner.next();
		System.out.println("Enter their type");
		String type = scanner.next();
		String line = username+" "+password+" "+type+",";
		try {
			DataStore.editCSV(userE.getUsername(), 0, line, "/src/logins.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void showProfile(Scanner scanner, User user) {
		System.out.println("Username "+user.getUsername());
		System.out.println("Password "+ user.getPassword());
		System.out.println("Role "+user.getUserType().toString());
		System.out.println("Phone number: XXXX XXX XXX");
		System.out.println("Email: someone@rmit.edu.au");
	}
	
	public static User logout(Scanner scanner) {
		System.out.println("User Logged Out...");
		return login(scanner);
	}

	public static void openTimetable(Scanner scanner, User user) {
		ArrayList<List<String>> times = null;
		try {
			times = DataStore.getTimetable();
			for(List<String> lines : times) {
				Classwork timetable = new Classwork(lines.get(3), lines.get(4), lines.get(5), lines.get(2), lines.get(1));
				System.out.println(timetable.toString());
//				if(lines.get(5).equalsIgnoreCase(user.getUsername())) {
//					System.out.println("Course: "+lines.get(1)+" Class: "+lines.get(2)+" Day: "+lines.get(3)+" Room: "+lines.get(4)+" Teacher: "+lines.get(5));
//					System.out.println("^^^^^^^^^^^^^^^^^^^^^");
//				} else {
//				System.out.println("Course: "+lines.get(1)+" Class: "+lines.get(2)+" Day: "+lines.get(3)+" Room: "+lines.get(4)+" Teacher: "+lines.get(5));
//				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void showAvailability(Scanner scanner, User user) {
		ArrayList<List<String>> times = null;
		try {
			times = DataStore.getTimetable();
			for(List<String> lines : times) {
				if(lines.get(5).equalsIgnoreCase(user.getUsername())) {
					System.out.println("Course: "+lines.get(1)+" Class: "+lines.get(2)+" Day: "+lines.get(3)+" Room: "+lines.get(4)+" Teacher: "+lines.get(5));
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static User searchTeachers(Scanner scanner, User user) {
		ArrayList<List<String>> accounts = null;
		try {
			accounts = DataStore.getAccounts();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Search By Username");
		String username = scanner.next();
		for (List<String> account : accounts) {
			try {
			if (account.get(0).equalsIgnoreCase(username)){
					System.out.println("Username: "+account.get(0)+" Password: "+account.get(1)+" Type: "+account.get(2));
					return  new User(account.get(0),account.get(1),account.get(2), "Phone Number", "Email");
			}
			}catch (Exception e){
				System.out.println("No teacher Found");
				break;
			}
		}
		return user;
	}

	public static void openStaffAppications(Scanner scanner, User user) {
		User staffUser= null;
		if(user.getUserType().equals(User.UserType.CASUALSTAFF)) {
			staffUser=user;
		} else {
			staffUser = searchTeachers(scanner, user);
		}
		System.out.println("Application for " + staffUser.getUsername());
		System.out.println(staffUser.getApplication());
		if(user.getUserType().equals(User.UserType.APPROVALS)) {
			System.out.println("which class are they applying for?");
			String classApply = scanner.next();
			System.out.println("approve? y/n");
			String response = scanner.next();
			if(response.equalsIgnoreCase("y")) {
				try {
					ArrayList<List<String>> timetable = DataStore.getTimetable();
					for(List<String> klass : timetable) {
						if(klass.get(2).equalsIgnoreCase(classApply)) {
							String structuredLine = klass.get(0)+" "+klass.get(1)+" "+klass.get(2)+" "+klass.get(3)+" "+klass.get(4)+" "+klass.get(5)+" "+staffUser.getUsername()+" "+"y"+",";
							DataStore.editCSV(klass.get(2), 2, structuredLine, "/src/classdata.csv");
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(user.getUserType().equals(User.UserType.CASUALSTAFF)) {
			System.out.println("edit application? y/n");
			String response = scanner.next();
			if(response.equalsIgnoreCase("y")) {
				System.out.println("rewrite application below");
				String application = scanner.next();
				String line = staffUser.getUsername()+" "+staffUser.getPassword()+""+staffUser.getUserType().toString()+" " +application+",";
				try {
					DataStore.editCSV(staffUser.getUsername(), 0, line, "/src/logins.csv");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void addTime(Scanner scanner, User user) {
		System.out.println("name course");
		String course = scanner.next();
		System.out.println("name class");
		String className = scanner.next();
		System.out.println("amount of time hour.minute -> (4.5 = 4:30)");
		String time = scanner.next();
		System.out.println("rate");
		String rate = scanner.next();
		String line = user.getUsername()+" "+course+" "+ className+" "+ time+" " + rate+ ",";
		try {
			DataStore.addCSV(line, "/src/timesheet.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void generateReports(Scanner scanner, User user) {
//		System.out.println("report grouping? (user/class/course)");
//		String type = scanner.next();
//		try {
//			ArrayList<List<String>> payroll = DataStore.getTimesheet();
//			if(type.equalsIgnoreCase("user")) {
//				
//			} else if(type.equalsIgnoreCase("class")) {
//				
//			} else if(type.equalsIgnoreCase("course")) {
//				
//			}else {
//				System.out.println("invalid report grouping");
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		try {
			ArrayList<List<String>> payroll = DataStore.getTimesheet();
			double total = 0;
			for(List<String> line : payroll) {
				double time = Double.parseDouble(line.get(3));
				double rate = Double.parseDouble(line.get(4));
				double sum = time*rate;
				total = total + sum;
				System.out.println("teacher name: "+line.get(0)+" course: "+line.get(1)+" class: "+line.get(2)+" time: "+line.get(3)+" rate: "+line.get(4)+" sum: "+sum);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static void createSemester(Scanner scanner, User user) {
		System.out.println("name semester");
		String semName = scanner.next();
		String line = semName+",";
		try {
			DataStore.addCSV(line, "/src/semester.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createCourse(Scanner scanner, User user) {
		System.out.println("name semester");
		String semName = scanner.next();
		System.out.println("name course");
		String coursename = scanner.next();
		System.out.println("name course code");
		String coursecode = scanner.next();
		System.out.println("name coordinator");
		String coordinator = scanner.next();
		String line = semName+" "+coursename+" "+coursecode+" "+coordinator+",";
		try {
			DataStore.addCSV(line, "/src/course.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createClassData(Scanner scanner, User user) {
		System.out.println("name semester");
		String semName = scanner.next();
		System.out.println("name course");
		String coursename = scanner.next();
		System.out.println("name class");
		String classdata = scanner.next();
		System.out.println("name day");
		String day = scanner.next();
		System.out.println("name room");
		String room = scanner.next();
		System.out.println("teacher");
		String teacher = scanner.next();
		System.out.println("approved? (y/n)");
		String approved = scanner.next();
		String line = semName+" "+coursename+" "+ classdata+" "+day+" "+room+" "+teacher+" "+approved+ ",";
		try {
			DataStore.addCSV(line, "/src/classdata.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
