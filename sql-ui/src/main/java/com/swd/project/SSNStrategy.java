package com.swd.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SSNStrategy implements SearchStrategy {
	public SSNStrategy() {
	}
	
	@Override
	public List<Employee> employeeSearch(String ssn) {
		List<Employee> employeeList = new ArrayList<>();
		String query = "SELECT * FROM Employees WHERE ssn = \"" + ssn + "\";";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
	        	  // Retrieve by column names
	        	  int employeeID = rs.getInt("emp_id");
	        	  String employeeFirstName = rs.getString("first_name");
	        	  String employeeLastName = rs.getString("last_name");
	        	  // ssn is of type String intentionally
	        	  String employeeSSN = rs.getString("ssn");
	        	  String jobTitle = rs.getString("job_title");
	        	  String division = rs.getString("Division");
	        	  double salary = rs.getDouble("salary");
	        	  // hireDate is of type String intentionally
	        	  String hireDate = rs.getString("hire_date");
	        	  
	        	  Employee employee = new Employee.EmployeeBuilder(
	        			  employeeID, employeeFirstName, employeeLastName, employeeSSN, jobTitle,
	        			  division, salary, hireDate).build();
	        	  
	        	  employeeList.add(employee);
	          }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	
	// SSN must be converted to emp_id
	public List<Payment> paymentSearch(String ssn) {
		List<Payment> paymentList = new ArrayList<>();
		int employeeID = -1;
		
		// Get employeeID from SSN in the employees table.
		String query = "SELECT emp_id FROM Employees WHERE ssn = \"" + ssn + "\";";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				employeeID = rs.getInt("emp_id");
	          }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (employeeID == -1) return paymentList;
		
		// Now that we have the employeeID, we get the list of payments from
		// the payments table.
		query = "SELECT * FROM Payments WHERE emp_id = \"" + employeeID + "\";";
		
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
