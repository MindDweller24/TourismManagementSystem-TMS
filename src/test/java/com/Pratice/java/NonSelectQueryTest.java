package com.Pratice.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int result = 0;
		try {
			// register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// get connection for database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet50", "root", "root");
			// create statement
			Statement state = con.createStatement();
			String query = "insert into SKM values(5,'anil','bihar',23,'movie');";
			// update query
			result = state.executeUpdate(query);
			System.out.println(result);

		} catch (Exception e) {

		} finally {
			if (result > 0) {
				System.out.println("data updated successfully");
			} else {
				System.out.println("data not inserted");
			}
		}

	}

}
