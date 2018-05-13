import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DataStore {
	private static ArrayList<List<String>> Accounts = new ArrayList<>(); 
	private static ArrayList<List<String>> Timetable = new ArrayList<>();
	private static ArrayList<List<String>> Timesheet = new ArrayList<>();
	
	private static ArrayList<List<String>> editing = new ArrayList<>();
	
	public static ArrayList<List<String>> getAccounts() throws FileNotFoundException {
		 String ctx = System.getProperty("user.dir");
	        Scanner scanner = new Scanner(new File(ctx + "/src/logins.csv"));
	        scanner.useDelimiter(",");
	        
	        while(scanner.hasNext()){
	        	String line = scanner.next();
             String[] values = line.split(" ");
             Accounts.add(Arrays.asList(values));
	        }
	        scanner.close();
		return Accounts;
	 }
	 
	 public static ArrayList<List<String>> getTimetable() throws FileNotFoundException {
		 String ctx = System.getProperty("user.dir");
	        Scanner scanner = new Scanner(new File(ctx + "/src/classdata.csv"));
	        scanner.useDelimiter(",");
	        
	        while(scanner.hasNext()){
	        	String line = scanner.next();
             String[] values = line.split(" ");
             Timetable.add(Arrays.asList(values));
	        }
	        scanner.close();
	        return Timetable;
	 }
	 
	 public static ArrayList<List<String>> getTimesheet() throws FileNotFoundException {
		 String ctx = System.getProperty("user.dir");
	        Scanner scanner = new Scanner(new File(ctx + "/src/timesheet.csv"));
	        scanner.useDelimiter(",");
	        
	        while(scanner.hasNext()){
	        	String line = scanner.next();
             String[] values = line.split(" ");
             Timesheet.add(Arrays.asList(values));
	        }
	        scanner.close();
	        return Timesheet;
	 }
	 
	 public static void addCSV(String structuredLine, String path) throws IOException {
		 String ctx = System.getProperty("user.dir");
		 FileWriter fw = new FileWriter(ctx+path, true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 bw.newLine();
		 bw.append(structuredLine);
		 bw.flush();
		 bw.close();
	 }
	 
	 public static void editCSV(String check, int compareCell,String structuredLine, String path) throws IOException {
		 String ctx = System.getProperty("user.dir");
		 Scanner scanner = new Scanner(new File(ctx + path));
	     scanner.useDelimiter(",");   
	     while(scanner.hasNext()){
	       	String line = scanner.next();
            String[] values = line.split(" ");
            editing.add(Arrays.asList(values));
	     }
	     scanner.close();
	     
	     for(List<String> lines : editing) {
	    	 if(lines.get(compareCell).equalsIgnoreCase(check)) {
	    		 editing.remove(lines);
	    		 editing.add(Arrays.asList(structuredLine.split(" ")));
	    	 }
	     }
	     
		 FileWriter fw = new FileWriter(ctx+path, false);
		 BufferedWriter bw = new BufferedWriter(fw);
		 for(List<String> lines : editing) {
			 bw.newLine();
			 bw.append(lines.toString());
		 }
		 bw.flush();
		 bw.close();
	 }
}
