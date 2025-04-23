package com.swd.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentTest {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
	   static final String USER = "root";
	   static final String PASS = "root";
	   static final String QUERY = "SELECT * FROM payments";
	   
	   public static void main(String[] arg) {
		   try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   Statement stmt = conn.createStatement();
				   ResultSet rs = stmt.executeQuery(QUERY);) {
			   while (rs.next()) {
				   int paymentID = rs.getInt("payment_id");
				   int employeeID = rs.getInt("emp_id");
				   String paymentDate = rs.getString("payment_date");
				   int amount = rs.getInt("amount");
				   
				   Payment examplePayment = new Payment.PaymentBuilder(
						   paymentID, employeeID, paymentDate, amount).build();

				   System.out.println(examplePayment.asString());
			   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	   }
}
