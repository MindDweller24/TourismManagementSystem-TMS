package com.newPratice.java;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void verify() {
		String actRes = "B";
		System.out.println("--step-1--");
		System.out.println("--step-2--");
		System.out.println("--step-3--");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actRes, "B");
		System.out.println("--step-4--");
		System.out.println("--step-5--");
		sa.assertAll();
	}

}
