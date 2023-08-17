package com.testNg;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.objectrepository.BookPackagePage;
import com.tms.objectrepository.MyTourHistoryPage;
import com.tms.objectrepository.TmsHomePage;

public class BookAndCancelTestngTest extends BaseClass {
@Test
public void bookAndCancel() throws Throwable {
	TmsHomePage th=new TmsHomePage(driver);
	th.home();
	wlib.scrollBarAction(driver);
	BookPackagePage bp = new BookPackagePage(driver);
	bp.detailButton();
	wlib.scrollBarAction(driver);
	Thread.sleep(2000);
	bp.bookPackage();
	wlib.scrollBarAction(driver);
	Thread.sleep(2000);
	bp.bookComment();
	bp.actualResult("SUCCESS:Booked Successfully");
	MyTourHistoryPage mth = new MyTourHistoryPage(driver);
	mth.TourHistory();
	mth.CancelTour();
	wlib.acceptAlert(driver);
	mth.actualResult("SUCCESS:Booking Cancelled successfully");	
}
}
