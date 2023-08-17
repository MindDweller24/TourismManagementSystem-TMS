package com.Pratice.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

	public class SelectQuery{
		public static void main(String[] args) throws Throwable {
			Connection conn=null;
			try {
				//register my sql to database
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				//get connection 
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet50", "root", "root");
				System.out.println("connection established");
				//create statement
				Statement state = conn.createStatement();
				String query = "Select* from SKM";
				//execute query
				ResultSet result = state.executeQuery(query);
				while(result.next()) {
					System.out.println(result.getString(1)+result.getString(2)+"--->"+result.getString(3));
					
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				conn.close();
			}
				
			
		}
		
	}

	
	
	

