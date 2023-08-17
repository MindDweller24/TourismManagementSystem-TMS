package com.tms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookPackagePage {

//Declaring the WebElement
	@FindBy(xpath = "//a[text()='Details']")
	private WebElement detailsbtn;

	@FindBy(id = "datepicker")
	private WebElement godatebtn;

	@FindBy(xpath = "//a[text()='2']")
	private WebElement date;

	@FindBy(id = "datepicker1")
	private WebElement retuendatebtn;

	@FindBy(xpath = "//a[text()='13']")
	private WebElement returndate;

	@FindBy(name = "comment")
	private WebElement comment;

	@FindBy(xpath = "//button[text()='Book']")
	private WebElement bookbtn;

	@FindBy(xpath = "//div[text()=':Booked Successfully ']")
	private WebElement actRes;

	// initializing the WebElements

	public BookPackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilizing the element

	public WebElement getDetailsbtn() {
		return detailsbtn;
	}

	public WebElement getGodatebtn() {
		return godatebtn;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getRetuendatebtn() {
		return retuendatebtn;
	}

	public WebElement getReturndate() {
		return returndate;
	}

	public WebElement getComment() {
		return comment;
	}

	public WebElement getBookbtn() {
		return bookbtn;
	}

	public WebElement getActRes() {
		return actRes;
	}

	public WebElement detailButton() {
		detailsbtn.click();
		return detailsbtn;
	}

	//business libraries

	public void bookPackage() {
		godatebtn.click();
		date.click();
		retuendatebtn.click();
		returndate.click();
	}
	public void bookComment() {
		comment.sendKeys("hi");
		bookbtn.click();
		
	}
@Test
	public void actualResult(String expData) {
		String text = actRes.getText();
		Assert.assertEquals(text, expData);
		System.out.println(text);
//		if (text.contains(expData)) {
//			System.out.println("package not booked");
//		} else {
//			System.out.println("Package has been booked successfully");
//		}

	}

	
}
