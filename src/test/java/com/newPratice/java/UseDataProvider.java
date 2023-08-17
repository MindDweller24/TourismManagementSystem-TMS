package com.newPratice.java;

import org.testng.annotations.DataProvider;

public class UseDataProvider {
//	@Test(dataProvider = "dataProviderTest")
//	public void dataTest(String place,String dest) {
//		System.out.println("place"+place+"----->"+"destination"+dest);
//		
//		
//	}

	@DataProvider
	public Object[][] dataProviderTest() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "odisha";
		obj[0][1] = "puri";

		obj[1][0] = "delhi";
		obj[1][1] = "faridabad";

		obj[2][0] = "mumbai";
		obj[2][1] = "juhu beach";
		return obj;
	}

	@DataProvider
	public Object[][] dataTest() {
		Object[][] obj = new Object[2][3];
		obj[0][0] = "breakfast";
		obj[0][1] = "spicy";
		obj[0][2] = "chicken wings";

		obj[1][0] = "dinner";
		obj[1][1] = "sweets";
		obj[1][2] = "gulabjamun";
		return obj;
	}

	@DataProvider
	public Object[][] game() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "cricket";
		obj[0][1] = "11";

		obj[1][0] = "basketball";
		obj[1][1] = "8";
		return obj;
	}

}
