package com.swd.project;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an easy way to generate an employee report with a simple method call
 * @author Debra Ritter
 */
public class FullTimeEmployeeReportFacade {
	/**
	 * Get all employees by searching for every Employee ID.
	 * Since EIDs are unique we'll get a list of all employees.
	 */
	public static void generateReport() {
		List<Employee> employeeList = new ArrayList<>();
		EmployeeIDStrategy employeeIDSearch = new EmployeeIDStrategy();
		employeeList = employeeIDSearch.employeeSearch("*");
		
		System.out.println("*".repeat(120));
		
		for (Employee e : employeeList) {
			System.out.println("Payment history for " + e.getFirstName() + " " + e.getLastName());
			System.out.println("-".repeat(120));
			System.out.println("Full employee information: " + e.asString());
			System.out.println("-".repeat(120));
			
			List<Payment> paymentList = new ArrayList<>();
			paymentList = employeeIDSearch.paymentSearch(Integer.toString(e.getEmployeeID()));
			System.out.println("PaymentID | EmployeeID | Date       | Amount (USD)");
			for (Payment p : paymentList) {
				System.out.print(p.getPaymentID() +  " ".repeat(8) + "| ");
				System.out.print(p.getEmployeeID() + " ".repeat(10) + "| ");
				System.out.print(p.getPaymentDate()  + " | ");
				System.out.print(p.getAmount());
				System.out.println();
			}
			
			System.out.println("*".repeat(120));
		}
	}
}
