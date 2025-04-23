package com.swd.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class for searching for an employee by their employee ID.
 * 
 * @author Debra Ritter
 */
public class EmployeeIDStrategy implements SearchStrategy {
	public EmployeeIDStrategy() {
	}

	//employeeID is of type String intentionally
	@Override
	public List<Employee> employeeSearch(String employeeID) {
		List<Employee> employeeList = new ArrayList<>();
		String query = "";
		// For search all employees vs a single employee
		if (employeeID.equals("*")) {
			// Difference is the use of quotes in the query
			query = "SELECT * FROM Employees;";
		} else {
			query = "SELECT * FROM Employees WHERE emp_id = " + employeeID + ";";
		}
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
	        	  // Retrieve by column names
	        	  int localEmployeeID = rs.getInt("emp_id");
	        	  String employeeFirstName = rs.getString("first_name");
	        	  String employeeLastName = rs.getString("last_name");
	        	  String employeeSSN = rs.getString("ssn");
	        	  String jobTitle = rs.getString("job_title");
	        	  String division = rs.getString("Division");
	        	  double salary = rs.getDouble("salary");
	        	  // hireDate is of type String intentionally
	        	  String hireDate = rs.getString("hire_date");
	        	  
	        	  Employee employee = new Employee.EmployeeBuilder(
	        			  localEmployeeID, employeeFirstName, employeeLastName, employeeSSN, jobTitle,
	        			  division, salary, hireDate).build();
	        	  
	        	  employeeList.add(employee);
	          }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	// employeeID is of type String intentionally
	@Override
	public List<Payment> paymentSearch(String employeeID) {
		List<Payment> paymentList = new ArrayList<>();
		String query = "SELECT * FROM Payments WHERE emp_id = \"" + employeeID + "\";";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				// Retrieve by column names
				int paymentID = rs.getInt("payment_id");
				int localemployeeID = rs.getInt("emp_id");
				String paymentDate = rs.getString("payment_date");
				int amount = rs.getInt("amount");
				
				Payment payment = new Payment.PaymentBuilder(paymentID, 
						localemployeeID, paymentDate, amount).build();
				
				paymentList.add(payment);
	          }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return paymentList;
	
	}

}
