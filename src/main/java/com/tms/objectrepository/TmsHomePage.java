package com.tms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TmsHomePage {
	// Declaring the WebEements
	// This is for admin button
	@FindBy(xpath = "//a[text()='Admin Login']")
	private WebElement adminbtn;

	// This is for sign in button
	@FindBy(xpath = "//a[text()='/ Sign In']")
	private WebElement userbtn;
	@FindBy(xpath = "//input[@placeholder='Enter your Email']")
	private WebElement emailbtn;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordbtn;
	@FindBy(xpath = "//a[text()='Forgot password']")
	private WebElement forgotbtn;
	@FindBy(name = "signin")
	private WebElement loginbtn;
	// This is for sign up Button
	@FindBy(xpath = "//a[text()='Sign Up']")
	private WebElement signupbtn;
	@FindBy(xpath = "//a[text()='Tour Packages']")
	private WebElement tourPkg;
	@FindBy(xpath = "//a[text()=' Enquiry ']")
	private WebElement enquiry;
	@FindBy(xpath= "//a[text()='Home']")
	private WebElement homebtn;

	

	// Initializing the WebElements
	public TmsHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilizing the WebElements
	public WebElement getAdminbtn() {
		return adminbtn;
	}

	public WebElement getUserbtn() {
		return userbtn;
	}

	public WebElement getEmailbtn() {
		return emailbtn;
	}

	public WebElement getPasswordbtn() {
		return passwordbtn;
	}

	public WebElement getForgotbtn() {
		return forgotbtn;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getSignupbtn() {
		return signupbtn;
	}

	public WebElement getTourPkg() {
		return tourPkg;
	}

	public WebElement getEnquiry() {
		return enquiry;
	}
	
	public WebElement getHomebtn() {
		return homebtn;
	}

	// business libraries
	public void adminLogin() {
		adminbtn.click();
	}

	public void userLogin(String name, String password) {
		userbtn.click();
		emailbtn.sendKeys(name);
		passwordbtn.sendKeys(password);
		loginbtn.click();
	}

	public void forgotPwd() {
		userbtn.click();
		forgotbtn.click();
	}

	public void singUp() {
		signupbtn.click();
	}

	public void tourPkg() {
		tourPkg.click();
	}

	public void enquiry() {
		enquiry.click();
	}
	public void home() {
		homebtn.click();
	}

}