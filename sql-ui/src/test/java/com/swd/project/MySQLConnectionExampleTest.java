package com.swd.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import io.github.cdimascio.dotenv.Dotenv;

class MySQLConnectionExampleTest {

    @Test
    void testConnectionAndSimpleQuery() throws SQLException {
        // 1) load the same .env you use in production
        Dotenv dotenv = Dotenv.load();

        String dbUrl = "jdbc:mysql://localhost:3306/test_database";
        String user  = dotenv.get("DB_USERNAME");
        String pass  = dotenv.get("DB_PASSWORD");

        // 2) open the connection, run the SELECT 'Hello…' query, and verify results
        try (Connection conn = DriverManager.getConnection(dbUrl, user, pass);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery("SELECT 'Hello from MySQL!' AS message;")) {

            // verify we got a valid, open connection
            assertNotNull(conn, "Connection should not be null");
            assertTrue(conn.isValid(2), "Connection should be valid within 2 seconds");

            // verify the ResultSet has at least one row
            assertTrue(rs.next(), "ResultSet should contain at least one row");

            // verify the text is exactly what we expect
            String message = rs.getString("message");
            assertEquals("Hello from MySQL!", message);
        }
    }
}
