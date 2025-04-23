package com.swd.project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
/**
 * This class is used for interacting with the employee management system.
 * @author Debra Ritter
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.println("Welcome to the employee management system for company "
				+ "Z! Type \"quit\" without quotes to quit. Otherwise please follow"
				+ "the instructions.");
		
		while(!input.equals("quit")) {
			System.out.println("What would you like to do?");
			System.out.println("1) Search for an employee");
			System.out.println("2) Update an employee");
			System.out.println("3) Update all employees salaries by a percent"
					+ " in a certain salary range");
			System.out.println("4) Add an SSN column with no dashes to the Employees table");
			System.out.println("5) Generate a report");
			
			input = scanner.nextLine();
			
			switch(input) {
			case "quit":
				break;
			case "1":
				// We have to pass scanner to avoid NoLineFound error
				if(!searchEmployee(scanner, input)) return;
				break;
			case "2":
				// We have to pass scanner to avoid NoLineFound error
				if(!updateEmployee(scanner, input)) return;
				break;
			case "3":
				// We have to pass scanner to avoid NoLineFound error
				// TODO
				if(!updateAllEmployees(scanner, input)) return;
				break;
			case "4":
				// We have to pass scanner to avoid NoLineFound error
				if(!addSSNColumnNoDashes(scanner, input)) return;
				break;
			case "5":
				// We have to pass scanner to avoid NoLineFound error
				// TODO
				if(!generateReport(scanner, input)) return;
				break;
			default:
				System.out.println("Incorrect input. Enter a number 1 through 5"
						+ " or enter quit to quit.");
			}
		}
		
		System.out.println("\"quit\" received, goodbye!");
		scanner.close();
	}
	
	public static boolean searchEmployee(Scanner scanner, String input) {
		if (input.equals("quit")) return false;
		List<Employee> list = null;
		String name = null;
		
		System.out.println("You've requested to search for an employee. How"
				+ " would you like to search?");
		System.out.println("A: By name");
		System.out.println("B: By SSN");
		System.out.println("C: By employeeID");
		
		String localInput = scanner.nextLine();
		
		switch(localInput) {
		case "quit":
			return false;
		case "A":
			NameStrategy nameSearch = new NameStrategy();
			
			System.out.println("Enter the name first and last name of the"
					+ " employee you'd like the search:");
			
			name = scanner.nextLine();
			list = nameSearch.employeeSearch(name);
			if(list.size() <= 0) break;
			
			System.out.println("The search returned the following information"
					+ " for " + list.size() + " employees:");
			
			for(Employee e : list) {
				System.out.println(e.asString());
			}
			System.out.println();
			
			break;
		case "B":
			SSNStrategy SSNSearch = new SSNStrategy();
			
			System.out.println("Enter the SSN of the"
					+ " employee you'd like the search:");
			
			name = scanner.nextLine();
			list = SSNSearch.employeeSearch(name);
			System.out.println("The search returned the following information"
					+ " for " + list.size() + " employees:");
			
			for(Employee e : list) {
				System.out.println(e.asString());
			}
			System.out.println();
			
			break;
		case "C":
			EmployeeIDStrategy EIDSearch = new EmployeeIDStrategy();
			
			System.out.println("Enter the employee ID of the"
					+ " employee you'd like the search:");
			
			name = scanner.nextLine();
			list = EIDSearch.employeeSearch(name);
			System.out.println("The search returned the following information"
					+ " for " + list.size() + " employees:");
			
			for(Employee e : list) {
				System.out.println(e.asString());
			}
			System.out.println();
			
			break;
		default:
			System.out.println("Invalid response, please try again.");
		}
		
		return true;
	}
	
	public static boolean updateEmployee(Scanner scanner, String input) {
		if (input.equals("quit")) return false;
		String newVar;
		String oldVar;
		double oldSalary;
		List<Employee> employeeList = new ArrayList<>();
		EmployeeUpdaterSingleton employeeUpdater = EmployeeUpdaterSingleton.getInstance();
		EmployeeIDStrategy employeeFinder = new EmployeeIDStrategy();
		
		System.out.println("You've requested to update an employee. "
				+ "Please enter their EID to update the relevant employee. Type"
				+ " \"back\" without quotes to go back.");
		
		String eID = scanner.nextLine();
		if (eID.equals("back")) {
			return true;
		}
		
		employeeList = employeeFinder.employeeSearch(eID);
		Employee employee = employeeList.get(0);
		System.out.println("The corresponding employee is:");
		System.out.println(employee.asString());
		
		System.out.println("Please enter the corresponding letter to the"
				+ " employee field you'd like to update. Type back to go back"
				+ " or quit to quit.");
		System.out.println("A: First name");
		System.out.println("B: Last name");
		System.out.println("C: SSN");
		System.out.println("D: Job Title");
		System.out.println("E: Division");
		System.out.println("F: Hire Date");
		System.out.println("G: Salary - direct change");
		System.out.println("H: Salary - percentage if in range");


		String localInput = scanner.nextLine();
		
		switch(localInput) {
		case "quit":
			scanner.close();
			return false;
		case "back":
			return true;
		case "A":
			System.out.println("What is the new first name you'd like to enter?");
			newVar = scanner.nextLine();
			oldVar = employee.getFirstName();
			employeeUpdater.updateFirstName(employee, newVar);
			break;
		case "B":
			System.out.println("What is the new last name you'd like to enter?");
			newVar = scanner.nextLine();
			oldVar = employee.getLastName();
			employeeUpdater.updateLastName(employee, newVar);
			break;
		case "C":
			System.out.println("What is the new SSN you'd like to enter?");
			newVar = scanner.nextLine();
			oldVar = employee.getSsn();
			employeeUpdater.updateSSN(employee, newVar);
			break;
		case "D":
			System.out.println("What is the new job title you'd like to enter?");
			newVar = scanner.nextLine();
			oldVar = employee.getJobTitle();
			employeeUpdater.updateJobTitle(employee, newVar);
			break;
		case "E":
			System.out.println("What is the new division you'd like to enter?");
			newVar = scanner.nextLine();
			oldVar = employee.getDivision();
			employeeUpdater.updateDivision(employee, newVar);
			break;
		case "F":
			System.out.println("What is the new hire date you'd like to enter?");
			newVar = scanner.nextLine();
			oldVar = employee.getHireDate();
			employeeUpdater.updateHireDate(employee, newVar);
			break;
		case "G":
			System.out.println("NOTE: This is the option to DIRECTLY change"
					+ " an employee's salary.");
			
			System.out.println("What is the new salary you'd like to enter?");
			newVar = scanner.nextLine();
			oldSalary = employee.getSalary();
			employeeUpdater.updateSalaryGeneric(employee, Double.parseDouble(newVar));
			break;
		case "H":
			System.out.println("NOTE: This is the option to change an "
					+ "employee's salary by a PERCENTAGE if they fall into a"
					+ " certain income bracket that you define.\n This option is"
					+ " included for posterity.");
			oldSalary = employee.getSalary();
			
			System.out.println("What is the new percentage you'd like to enter?");
			newVar = scanner.nextLine();
			System.out.println("What is the lower bound of the salary check?");
			double lowBound = Double.parseDouble(scanner.nextLine());
			System.out.println("What is the upper bound of the salary check?");
			double upBound = Double.parseDouble(scanner.nextLine());
			
			employeeUpdater.updateSalaryPercentRange(employee, 
					Double.parseDouble(newVar), lowBound, upBound);
			break;
		}
		
		return true;
	}
	
	public static boolean addSSNColumnNoDashes(Scanner scanner, String input) {
		if (input.equals("quit")) return false;
		
		System.out.println("This will add an SSN column to the Employees table"
				+ " if it does not already exist. Type Y to confirm.");
		System.out.println("Type \"back\" without quotes to go back");
		String localInput = scanner.nextLine();
		
		switch(localInput) {
		case "quit":
			return false;
		case "back":
			return true;
		case "Y":
			AddSSNSingleton tester =  AddSSNSingleton.getInstance();
			tester.addSNNColumn();
			break;
		default:
			System.out.println("Invalid response, please try again.");
		}
		
		return true;
	}
	
	public static boolean updateAllEmployees(Scanner scanner, String input) {
		if (input.equals("quit"))
			return false;

		System.out.println("This will update various employees salaries by a given"
				+ " percentage for employees whose current salaries are less"
				+ " than a given bound. Type Y to confirm.");
		System.out.println("Type \"back\" or \"quit\" without quotes to go back"
				+ " or quit.");
		String localInput = scanner.nextLine();

		switch (localInput) {
			case "quit":
				return false;
			case "back":
				return true;
			case "Y":
				System.out.println("What is the new percentage you'd like to enter?");
				double percent = Double.parseDouble(scanner.nextLine());
				System.out.println("What is the upper bound of the salary check?");
				double upBound = Double.parseDouble(scanner.nextLine());

				UpdateAllEmployeesFacade.updateAllSalariesByPercent(percent, upBound);
				break;
			default:
				System.out.println("Invalid response, please try again.");
		}
		return true;
	}
	
	public static boolean generateReport(Scanner scanner, String input) {
		if (input.equals("quit")) return false;
		
		System.out.println("You've requested to generate a report. What kind of"
				+ " report would you like generated? You can also type \"back\""
				+ " or \"quit\" without quotes to go back.");
		System.out.println("A: Full time employee report");
		System.out.println("B: Total pay by month by division report");
		System.out.println("C: Total pay by month by job title report");
		
		String month;
		String localInput = scanner.nextLine();
		
		switch(localInput) {
		case "quit":
			scanner.close();
			return false;
		case "back":
			return true;
		case "A":
			FullTimeEmployeeReportFacade.generateReport();
			break;
		case "B":
			TotalPayByMonthDivision divisionInstance = new TotalPayByMonthDivision();
			
			System.out.println("Please enter the full name of the month"
					+ " for the report organized by division.");
			month = scanner.nextLine();
			
			divisionInstance.getTotalPayByMonth(month);
			break;
		case "C":
			TotalPayByMonthJobTitle jobTitleInstance = new TotalPayByMonthJobTitle();

			System.out.println("Please enter the full name of the month"
					+ " for the report organized by job title.");
			month = scanner.nextLine();
			
			jobTitleInstance.getTotalPayByMonth(month);
			break;
		}
		return true;
	}
}
