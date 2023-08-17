package com.newPratice.java;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgTest {
	@BeforeSuite
	public void connect_Db() {
		System.out.println("--connect to db--");

	}

	@AfterSuite
	public void dissconnect_Db() {
		System.out.println("--close db--");
	}

	@BeforeClass
	public void launch_Browser() {
		System.out.println("--launch the browser--");
	}

	@AfterClass
	public void close_Browser() {
		System.out.println("--close the browser--");
	}

	@BeforeMethod
	public void login_ASppl() {
		System.out.println("--login to app--");
	}

	@Test
	public void run_Script() {
		System.out.println("--run the test script---");
	}

}
