package com.swd.project;
import java.util.ArrayList;
import java.util.List;

/**
 * Tester class for EmployeeUpdaterSingleton
 * TODO: Write more test cases corresponding to 5a and 5b project deliverables.
 * 
 * @author Debra Ritter
 */
public class EmployeeUpdaterSingletonTest {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		NameStrategy nameTester = new NameStrategy();
		SSNStrategy SSNTester = new SSNStrategy();
		EmployeeIDStrategy EIDTester = new EmployeeIDStrategy();
		EmployeeUpdaterSingleton employeeUpdater = EmployeeUpdaterSingleton.getInstance();
		
		// Update first name and change it back 
		employeeList = nameTester.employeeSearch("Michael Brown");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateFirstName(employee, "Mike");
		}
		
		employeeList = nameTester.employeeSearch("Mike Brown");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateFirstName(employee, "Michael");
		}
		
		employeeList = nameTester.employeeSearch("Michael Brown");
		System.out.println(employeeList.get(0).asString());
		
		// Update last name and change it back
		System.out.println();
		employeeList = nameTester.employeeSearch("Michael Brown");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateLastName(employee, "Green");
		}
		
		employeeList = nameTester.employeeSearch("Michael Green");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateLastName(employee, "Brown");
		}
		
		employeeList = nameTester.employeeSearch("Michael Brown");
		System.out.println(employeeList.get(0).asString());
		
		// Update SSN and change it back
		System.out.println();
		employeeList = SSNTester.employeeSearch("666778899");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateSSN(employee, "998877666");
		}
		
		employeeList = SSNTester.employeeSearch("998877666");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateSSN(employee, "666778899");
		}
		
		employeeList = SSNTester.employeeSearch("666778899");
		System.out.println(employeeList.get(0).asString());
		
		// Update Job Title and change it back
		System.out.println();
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateJobTitle(employee, "Manager");
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateJobTitle(employee, "Sales Representative");
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		// Update Division and change it back
		System.out.println();
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateDivision(employee, "Management");
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateDivision(employee, "Sales");
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		// Update Salary Generically and change it back
		System.out.println();
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateSalaryGeneric(employee, 1.0);
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateSalaryGeneric(employee, 70000.0);
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		// Update Salary with percent range and change it back
		// Salary should be 72240
		System.out.println();
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateSalaryPercentRange(employee, 3.2, 58000.0, 105000.0);
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		// Testing range
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateSalaryPercentRange(employee, 3.2, 58000.0, 58000.0);
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		// For changing it back we just do it generically
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateSalaryGeneric(employee, 70000.0);
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		// Update HireDate and change it back
		System.out.println();
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateHireDate(employee, "0001-01-01");
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateHireDate(employee, "2022-07-05");
		}
		
		employeeList = EIDTester.employeeSearch("5");
		System.out.println(employeeList.get(0).asString());
	}

}
