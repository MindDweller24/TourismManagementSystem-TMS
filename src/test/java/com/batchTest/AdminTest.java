package com.batchTest;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;

public class AdminTest extends BaseClass {
	@Test
	public void createTour() {
		System.out.println("--tour package created");
	}

	@Test
	public void bookticket() {
		System.out.println("--ticket booking");
	}

	@Test
	public void cancelTour() {
		System.out.println("--tour cancelled");
	}
}
