package assignment;

import java.util.Scanner;

public class Executable {

	public static void main(String[] args) {
		User cs1 = new CasualStaff("e1235", "TestStaff", 1298, "TestEmail");
		logIntoSystem(cs1);
		
	}

	public static boolean logIntoSystem(User cs1) {
		String enteredID;
		String enteredPass;

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your employee ID: ");
		enteredID = kb.nextLine();

		System.out.println("Enter your Password: ");
		enteredPass = kb.nextLine();
		
		
		
		//if matches
	return true;
	
	//else
	//return false;
	}

}
