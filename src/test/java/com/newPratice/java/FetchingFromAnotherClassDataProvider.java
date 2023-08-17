package com.newPratice.java;

import org.testng.annotations.Test;

@Test(dataProviderClass = UseDataProvider.class, dataProvider = "dataProviderTest")
public class FetchingFromAnotherClassDataProvider {
	public void getData(String place, String dest) {
		System.out.println("place " + "------>" + place + " destination" + "------>" + dest);

	}

	@Test(dataProviderClass = UseDataProvider.class, dataProvider = "dataTest")
	public void getData(String food, String taste, String dish) {
		System.out.println("food" + "----->" + food + " taste" + "------->" + taste + " dishname" + "------>" + dish);
	}

	@Test(dataProviderClass = UseDataProvider.class, dataProvider = "game")
	public void getData(String Game, int players) {
		System.out.println("Game" + "----->" + Game + " Country" + "------->" + players);
	}

}
