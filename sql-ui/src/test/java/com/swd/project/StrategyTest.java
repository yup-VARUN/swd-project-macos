package com.swd.project;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StrategyTest {
	@Test
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		List<Payment> paymentList = new ArrayList<>();
		
		NameStrategy nameTester = new NameStrategy();
		SSNStrategy ssnTester = new SSNStrategy();
		EmployeeIDStrategy empIDTester = new EmployeeIDStrategy();
		
		// Test searching Employees by name
		employeeList = nameTester.employeeSearch("John Doe");
		for (Employee employee : employeeList) {
			System.out.println(employee.asString());
		}
		
		// Test searching Payments by name
		paymentList = nameTester.paymentSearch("John Doe");
		for (Payment p : paymentList) {
			System.out.println(p.asString());
		}
		
		// Test searching Employees by ssn
		employeeList = ssnTester.employeeSearch("111223344");
		for (Employee employee : employeeList) {
			System.out.println(employee.asString());
		}
		
		// Test searching Payments by ssn
		paymentList = ssnTester.paymentSearch("111223344");
		for (Payment p : paymentList) {
			System.out.println(p.asString());
		}
		
		// Test searching Employees by emp_id
		employeeList = empIDTester.employeeSearch("8");
		for (Employee employee : employeeList) {
			System.out.println(employee.asString());
		}
		
		// Test searching Payments by emp_id
		paymentList = empIDTester.paymentSearch("8");
		for (Payment p : paymentList) {
			System.out.println(p.asString());
		}
	}

}
