package com.newPratice.java;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void hardAssertTest() {
		System.out.println("---step-1---");
		System.out.println("---step-2---");
		Assert.assertEquals("A", "B");
		System.out.println("---step-3---");
		System.out.println("---step-4---");
		System.out.println("---step-5---");
		fail();
		
	}
	    @Test
	    public void test() {
	    	System.out.println("---step-6---");
	    	System.out.println("---step-7---");
	    	int a=10;
	    	Assert.assertNull(a);
	    	System.out.println("---step-8---");
	    }

}
