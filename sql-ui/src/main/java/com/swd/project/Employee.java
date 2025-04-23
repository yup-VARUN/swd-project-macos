package com.swd.project;

public class Employee {
	private int employeeID;
	private String firstName;
	private String lastName;
	
	// Matching VARCHAR(9) in Employees table
	private String ssn;
	
	private String jobTitle;
	private String division;
	private double salary;
	
	// Make sure this is formatted as DateTime
	private String hireDate;
	
	public Employee(Employee.EmployeeBuilder employeeBuilder) {
		this.employeeID = employeeBuilder.employeeID;
		this.firstName = employeeBuilder.firstName;
		this.lastName = employeeBuilder.lastName;
		this.ssn  = employeeBuilder.ssn;	
		this.jobTitle = employeeBuilder.jobTitle;
		this.division = employeeBuilder.division;
		this.salary = employeeBuilder.salary;
		this.hireDate = employeeBuilder.hireDate;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getDivision() {
		return division;
	}

	public double getSalary() {
		return salary;
	}

	public String getHireDate() {
		return hireDate;
	}
	
	public String asString() {
		return "EmployeeID: " + this.getEmployeeID() +
  			  " First Name: " + this.getFirstName() +
  			  " Last Name: "+ this.getLastName() +
  			  " SSN: " + this.getSsn() + 
  			  "\n" +
  			  "Phone Number: " + this.getSsn() +
  			  " Job Title: " + this.getJobTitle() +
  			  " Division: "+ this.getDivision() +
  			  " Salary: "+ this.getSalary() +
  			  " Hire Date: "+ this.getHireDate();
	}
	
	public static class EmployeeBuilder {
		private int employeeID;
		private String firstName;
		private String lastName;
		
		// Matching VARCHAR(9) in Employees table
		private String ssn;
		
		private String jobTitle;
		private String division;
		private double salary;
		
		// Make sure this is formatted as DateTime
		private String hireDate;

		public EmployeeBuilder(int employeeID, String firstName, 
				String lastName, String ssn, String jobTitle, String division,
				double salary, String hireDate) {
			this.employeeID = employeeID;
			this.firstName = firstName;
			this.lastName = lastName;
			this.ssn = ssn;
			this.jobTitle = jobTitle;
			this.division = division;
			this.salary = salary;
			this.hireDate = hireDate;
		}
		
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setSsn(String ssn) {
			SSNValidator validator = SSNValidatorSingleton.getInstance();
			
			if (validator.validate(ssn)) {
				this.ssn = ssn;
			} else {
				System.out.println("Re-enter SSN");
			}
			
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		public void setDivision(String division) {
			this.division = division;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public void setHireDate(String hireDate) {
			// TODO: Implement validator
			this.hireDate = hireDate;
		}
		
		public Employee build() {
			return new Employee(this);
		}
	}
}
