package com.swd.project;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * This is an interface for total by month.
 * To be used by TotalPayByMonthJobTitle and TotalPayByMonthDivision
 */
public interface TotalPayByMonth {
    static final Dotenv DOTENV = Dotenv.load();
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
    static final String USER   = DOTENV.get("DB_USERNAME");
    static final String PASS   = DOTENV.get("DB_PASSWORD");
	
	public void getTotalPayByMonth(String month);
}
