package com.testNg;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.objectrepository.AdminHomePage;
import com.tms.objectrepository.ManagePackagesPage;
import com.tms.objectrepository.UpdatePackagePage;

public class ManagePackageTestNgTest extends BaseClass{
	@Test
	public void managePackage() throws Throwable {
	AdminHomePage ah = new AdminHomePage(driver);
	ah.tour();
	//fail();
	ah.updatePkg();
	ManagePackagesPage mp = new ManagePackagesPage(driver);
	mp.details();
	UpdatePackagePage up = new UpdatePackagePage(driver);
	Thread.sleep(2000);
	up.updatePackage();
	wlib.scrollBarAction(driver);
	up.actualResult("UPDATE");

}
}

