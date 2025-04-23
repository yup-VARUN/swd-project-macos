package com.swd.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class gets the total pay by a given month and groups by JobTitle
 * 
 * @author Debra Ritter
 */
public class TotalPayByMonthJobTitle implements TotalPayByMonth {
	TotalPayByMonthJobTitle() {
		
	}

	@Override
	public void getTotalPayByMonth(String month) {
		System.out.println("*".repeat(120));
		System.out.println("Total pay for month: " + month);
		System.out.println("*".repeat(120));
		String query = "select e.job_title, sum(p.amount) as total_pay "
				+ "from payments p join employees e on e.emp_id = p.emp_id "
				+ "where monthname(p.payment_date) = '" + month + "'"
				+ "group by e.job_title;";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				String jobTitle = rs.getString("job_title");
				int total_pay = rs.getInt("total_pay");
				
				System.out.println("Total pay for " + jobTitle + "s in " + month 
				+ ", $" + total_pay);
				System.out.println("-".repeat(40));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
