package com.newPratice.java;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tms.GenericUtility.ExcelUtility;

public class Sports {

	@Test(dataProvider = "text")
	public void excelData(String Player, String Age, String Country) {
		System.out.println(Player + "---->" + "" + Age + "----->" + Country);
	}

	@DataProvider
	public Object[][] text() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		Object[][] data = elib.getExcelDataDP("Sports");
		return data;

	}

}
