package com.batchTest;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;

public class TourPackageTest extends BaseClass{
	@Test
	public void createTour() {
		System.out.println("--creating tour");
	}

	@Test
	public void updatingPackage() {
		System.out.println("--package updated");
	}

}
