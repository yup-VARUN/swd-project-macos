package com.swd.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
	   static final String USER = "root";
	   static final String PASS = "root";
	   static final String QUERY = "SELECT * FROM employees";

		@Test  
	   public static void main(String[] args) {
		      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    	         Statement stmt = conn.createStatement();
		    	         ResultSet rs = stmt.executeQuery(QUERY);) {
		    	  		// Extract data from Result Set
		    	          while (rs.next()) {
		    	        	  // Retrieve by column names
		    	        	  int employeeID = rs.getInt("emp_id");
		    	        	  String firstName = rs.getString("first_name");
		    	        	  String lastName = rs.getString("last_name");
		    	        	  // ssn is of type String intentionally
		    	        	  String ssn = rs.getString("ssn");
		    	        	  String jobTitle = rs.getString("job_title");
		    	        	  String division = rs.getString("Division");
		    	        	  double salary = rs.getDouble("salary");
		    	        	  // hireDate is of type String intentionally
		    	        	  String hireDate = rs.getString("hire_date");
		    	        	  
		    	        	  Employee exampleEmployee = new Employee.EmployeeBuilder(
		    	        			  employeeID, firstName, lastName, ssn, jobTitle,
		    	        			  division, salary, hireDate).build();
		    	        	  
		    	        	  System.out.println(exampleEmployee.asString());
		    	          }
		    	      } catch (SQLException e) {
		    	         e.printStackTrace();
		    	      }
	   }
}
