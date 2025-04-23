package com.swd.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class MySQLConnectionExample {

    // load once when the class is initialized
    private static final Dotenv DOTENV = Dotenv.load();

    // declared at class level
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_database";
    private static final String USER   = DOTENV.get("DB_USERNAME");
    private static final String PASS   = DOTENV.get("DB_PASSWORD");
    
    
    
    public static void main(String[] args) {
        System.out.println("Attempting to connect to database…");
        System.out.println(DOTENV.get("DB_USERNAME"));
        System.out.println(DOTENV.get("DB_PASSWORD"));

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery("SELECT 'Hello from MySQL!' AS message;")) {

            System.out.println("Database connection successful!");

            if (rs.next()) {
                System.out.println("Query Result: " + rs.getString("message"));
            }
        } catch (SQLException e) {
            System.err.println("Database connection or query failed!");
            e.printStackTrace(System.err);
        }
        System.out.println("Finished.");
    }
}
