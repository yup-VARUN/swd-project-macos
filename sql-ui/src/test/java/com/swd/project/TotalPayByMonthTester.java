package com.swd.project;
/**
 * This is a tester class for generating reports for a month
 * by job title or division
 * 
 * TODO Write more test cases
 * 
 * @author Debra Ritter
 */
public class TotalPayByMonthTester {

	public static void main(String[] args) {
		TotalPayByMonthJobTitle jobTitleInstance = new TotalPayByMonthJobTitle();
		jobTitleInstance.getTotalPayByMonth("November");
		
		TotalPayByMonthDivision divisionInstance = new TotalPayByMonthDivision();
		divisionInstance.getTotalPayByMonth("November");
		
		// Test case: lower case
		divisionInstance.getTotalPayByMonth("november");
	}

}
