package com.swd.project;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for updating all employees with a single method call
 * updateAllEmployees()
 * 
 * Deliverable item 5c
 * 
 * @author Debra Ritter
 */
public class UpdateAllEmployeesFacade {
	public static void updateAllSalariesByPercent(double percent, double upperBound) {
		List<Employee> employeeList = new ArrayList<>();
		EmployeeIDStrategy employeeIDSearch = new EmployeeIDStrategy();
		employeeList = employeeIDSearch.employeeSearch("*");
		EmployeeUpdaterSingleton salaryUpdater = EmployeeUpdaterSingleton.getInstance();
		
		for (Employee e: employeeList) {
			salaryUpdater.updateSalaryPercentRange(e, percent, 0, upperBound);
		}
	}
}
