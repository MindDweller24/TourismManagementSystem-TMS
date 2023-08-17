package com.tms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTourHistoryPage {
	// Declaring the WebElements
	@FindBy(xpath = "//a[text()='My Tour History']")
	private WebElement tourhistorybtn;

	@FindBy(xpath = "//table/tbody/tr[last()]/td/a[text()='Cancel']")
	private WebElement canceltourbtn;

	@FindBy(xpath = "//div[text()=':Booking Cancelled successfully ']")
	private WebElement actualRes;

	// initializing the WebElements
	public MyTourHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilizing the WebElements

	public WebElement getTourhistorybtn() {
		return tourhistorybtn;
	}

	public WebElement getCanceltourbtn() {
		return canceltourbtn;
	}

	public WebElement getActualRes() {
		return actualRes;
	}

	// business libraries
	public void TourHistory() {
		tourhistorybtn.click();
	}

	public void CancelTour() {
		canceltourbtn.click();
	}
@Test
	public void actualResult(String expData) {
		String text = actualRes.getText();
		Assert.assertEquals(text, expData, text);
		System.out.println(text);
//		if (text.contains(expData)) {
//			System.out.println("package not cancelled");
//		} else {
//			System.out.println("Package has been cancelled successfully");
//		}

	}

}
