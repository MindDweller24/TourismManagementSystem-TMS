package com.testNg;

import java.io.File;

import java.util.HashMap;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.objectrepository.AdminHomePage;
import com.tms.objectrepository.CreatePackagePage;

//@Listeners(com.tms.GenericUtility.ListenersImplementation.class)
public class CreateTourTestNgTest extends BaseClass {
	@Test
	//@Test(retryAnalyzer =com.tms.GenericUtility.RetryImpClass.class)
	public void createPkg() throws Throwable {
	AdminHomePage ahp = new AdminHomePage(driver);
	ahp.tour();
	ahp.create();
	CreatePackagePage cp = new CreatePackagePage(driver);
	// cp.createTour("bengaluru", "couple", "lalbagh", "10", "nature", "food,soda");
	HashMap<String, String> getdata = elib.getMultipleExcelData("Package", 0, 1, driver);
	cp.getData(driver, getdata);
	wlib.scrollBarAction(driver);
	File file = new File(".\\src\\test\\resources\\friends.jpg");
	String absPath = file.getAbsolutePath();
//	fail();
	cp.packgImgpath(absPath);
	cp.createPackage();
	cp.actualResult("SUCCESS");

}
}
