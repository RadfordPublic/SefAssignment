package assignment;

import java.util.Scanner;

public class Executable {
	
	private static boolean checked=false;

	public static void main(String[] args) {
		User cs1 = new CasualStaff("e1235", "TestStaff", 1298, "TestEmail");
		do {
			logIntoSystem(cs1);
		} while (!checked);

	}

	public static void logIntoSystem(User cs1) {
		String enteredID;
		String enteredPass;

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your employee ID: ");
		enteredID = kb.nextLine();

		System.out.println("Enter your Password: ");
		enteredPass = kb.nextLine();

		if (cs1.getEmployeeID().compareTo(enteredID) == 0 && enteredPass.compareTo( "Password")==0) {
			System.out.println("Succefully loged into the system");
			//Do something
			checked=true;
		} 
		
		else
		{
			System.out.println("Login Fail. Try Again.");
			checked=false;
		}
	}

}
