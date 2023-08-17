package com.tms.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con = null;

	/**
	 * This method is used to connect database
	 * 
	 * @author Sanat
	 * @throws SQLException
	 */
	public void connectToDataBase() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.dbUSERNAME, IpathConstants.dbPASSWORD);

	}

	/**
	 * this method is used to execute query and get the data
	 * 
	 * @author Sanat
	 * @param query
	 * @param column	a	
	 * @param ExpData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int column, String ExpData) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String data = result.getString(column);
			{
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("---data is verified");
			return ExpData;
		} else {
			System.out.println("----data is not present");
			return "";
		}

	}

	public void closeDatabase() throws Throwable {
		con.close();
	}

}
