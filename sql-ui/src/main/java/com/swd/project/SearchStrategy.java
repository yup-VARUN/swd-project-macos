package com.swd.project;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;

public interface SearchStrategy {
    static final Dotenv DOTENV = Dotenv.load();
	
    // declared at class level
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
    static final String USER   = DOTENV.get("DB_USERNAME");
    static final String PASS   = DOTENV.get("DB_PASSWORD");
	
	// For searching the Employees database
	public List<Employee> employeeSearch(String input);

	// For searching the Payments database 
	public List<Payment> paymentSearch(String input);
}
