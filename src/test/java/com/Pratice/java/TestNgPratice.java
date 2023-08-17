package com.Pratice.java;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNgPratice {

	@Test(priority = 2, enabled = true)
	public void searchPg() {
		System.out.println("searching for a Pg");
	}

	@Test(priority = 3)
	public void pgFood() {
		System.out.println("food should be eatable");
	}

	@Test(priority = 1, dependsOnMethods = "searchPg")
	public void pgPrice() {
		int price = 8000, b;
		System.out.println(b = price / 0);
		System.out.println(b);
		System.out.println("price should be below 7000");
	}

	@Ignore()
	public void pgDistance() {
		System.out.println("should be less than 1km");
	}

}
