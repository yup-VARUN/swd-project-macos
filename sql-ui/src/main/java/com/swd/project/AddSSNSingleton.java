package com.swd.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class AddSSNSingleton {
	public static AddSSNSingleton instance;

	private static final Dotenv DOTENV = Dotenv.load();
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
    static final String USER   = DOTENV.get("DB_USERNAME");
	static final String PASS = DOTENV.get("DB_PASSWORD");

	private AddSSNSingleton() {
		
	}
	
	public static AddSSNSingleton getInstance() {
		if (instance == null) {
			instance = new AddSSNSingleton();
		}
		
		return instance;
	}
	
	private static boolean checkColumnExistence(String name) {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Employees");
			    ) {
			ResultSetMetaData rsMetaData = rs.getMetaData();
			// getColumnCount() is indexed at 1 for some reason
			for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
				if (rsMetaData.getColumnName(i).equals(name)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void addSNNColumn() {
		if (!checkColumnExistence("ssn_no_dashes")) {
			System.out.println("Column ssn_no_dashes has already been added.");
			return;
		}
		
		String updateStatement = "ALTER TABLE Employees ADD ssn_no_dashes CHAR(9);";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement pstmt = conn.prepareStatement(updateStatement);) {
			pstmt.executeUpdate();
			// Make sure to add System.out.println in relevant update methods.
			System.out.print("Successfully added an SSN column with no dashes.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
