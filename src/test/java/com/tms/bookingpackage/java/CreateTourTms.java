package com.tms.bookingpackage.java;

import org.testng.annotations.Test;

public class CreateTourTms  {
	@Test
	public void createPkg() throws Throwable {
		
		CreatePackageTest ct=new CreatePackageTest();
		ct.createTour();
		
	}

}
