package com.swd.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class EmployeeUpdaterSingleton {
	public static EmployeeUpdaterSingleton instance;
    private static final Dotenv DOTENV = Dotenv.load();
	
    // declared at class level
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
    static final String USER   = DOTENV.get("DB_USERNAME");
    static final String PASS   = DOTENV.get("DB_PASSWORD");
	
	private EmployeeUpdaterSingleton() {
		
	}
	
	public static EmployeeUpdaterSingleton getInstance() {
		if (instance == null) {
			instance = new EmployeeUpdaterSingleton();
		}
		
		return instance;
	}
	
	// Note that you cannot update the emp_id, because it's the primary key
	// All update methods follow update generic
	private static void updateGeneric(Employee employee, String newCell, String column) {
		// Get the emp_id, because it's unique
		int employeeID = employee.getEmployeeID();
		String updateStatement = "UPDATE Employees SET " + column + " = \""
				+ newCell + "\" WHERE emp_id = " + employeeID + ";";
		
		// PreparedStatement is different from Statement because it prevents
		// SQL injection.
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement pstmt = conn.prepareStatement(updateStatement);) {
			pstmt.executeUpdate();
			// Make sure to add System.out.println in relevant update methods.
			System.out.print("Successfully updated employeeID " + employeeID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Overloaded method
	private static void updateGeneric(Employee employee, double newCell, String column) {
		// Get the emp_id, because it's unique
		int employeeID = employee.getEmployeeID();
		String updateStatement = "UPDATE Employees SET " + column + " = \""
				+ newCell + "\" WHERE emp_id = " + employeeID + ";";
		
		// PreparedStatement is different from Statement because it prevents
		// SQL injection.
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement pstmt = conn.prepareStatement(updateStatement);) {
			pstmt.executeUpdate();
			// Make sure to add System.out.println in relevant update methods.
			System.out.print("Successfully updated employeeID " + employeeID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFirstName(Employee employee, String newFirstName) {
		String oldName = employee.getFirstName();
		updateGeneric(employee, newFirstName, "first_name");
		System.out.println("\'s first name from " + oldName + " to " + newFirstName);
	}
	
	public void updateLastName(Employee employee, String newLastName) {
		String oldName = employee.getLastName();
		updateGeneric(employee, newLastName, "last_name");
		System.out.println("\'s last name from " + oldName + " to " + newLastName);
	}
	
	// Using the SSNValidator Singleton
	public void updateSSN(Employee employee, String newSSN) {
		SSNValidator validator = SSNValidatorSingleton.getInstance();
		if (!validator.validate(newSSN)) {
			System.out.println("SSN is not valid.");
			return;
		}
		
		String oldSSN = employee.getSsn();
		updateGeneric(employee, newSSN, "ssn");
		System.out.println("\'s SSN from " + oldSSN + " to " + newSSN);
	}
	
	public void updateJobTitle(Employee employee, String newJobTitle) {
		String oldJobTitle = employee.getJobTitle();
		updateGeneric(employee, newJobTitle, "job_title");
		System.out.println("\'s job title from " + oldJobTitle + " to " + newJobTitle);
	}
	
	public void updateDivision(Employee employee, String newDivision) {
		String oldDivision = employee.getDivision();
		updateGeneric(employee, newDivision, "division");
		System.out.println("\'s division from " + oldDivision + " to " + newDivision);
	}
	
	public void updateSalaryGeneric(Employee employee, double newSalary) {
		double oldSalary = employee.getSalary();
		updateGeneric(employee, newSalary, "salary");
		System.out.println("\'s salary from " + oldSalary + " to " + newSalary);
	}
	
	public void updateSalaryPercentRange(Employee employee, double percent,
			double lowerBound, double upperBound) {
		double oldSalary = employee.getSalary();
		
		// Only update salaries that fall into the specified range
		if (oldSalary < lowerBound || oldSalary >= upperBound) {
			System.out.println("Salary is not in range.");
			return;
		}
		
		// Percent increase logic.
		// 1) Multiple percent by 1/100 to scale to 100%. I.E. 3.2% scales to 0.032
		// 2) Add one to that number to scale by increase. I.E. a 3.2% percent
		// increase means an increase by 1.032 * oldSalary
		double newSalary = (1.0 + 0.01 * percent) * oldSalary;
		updateGeneric(employee, newSalary, "salary");
		System.out.println("\'s salary from " + oldSalary + " to " + newSalary);
	}
	
	public void updateHireDate(Employee employee, String newHireDate) {
		String oldHireDate = employee.getHireDate();
		updateGeneric(employee, newHireDate, "hire_date");
		System.out.println("\'s salary from " + oldHireDate + " to " + newHireDate);
	}
}
