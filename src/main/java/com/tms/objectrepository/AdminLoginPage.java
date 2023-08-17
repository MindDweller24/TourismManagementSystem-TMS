package com.tms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	// declaring the WebElement

	@FindBy(name = "username")
	private WebElement UserEdt;

	@FindBy(name = "password")
	private WebElement PwdEdt;

	@FindBy(name = "login")
	private WebElement submit;
	@FindBy(xpath = "//a[text()='Back to home']")
	private WebElement backHome;

	// initializing the WebElement
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	// utilizing the WebElement

	public WebElement getUserEdt() {
		return UserEdt;
	}

	public WebElement getPwdEdt() {
		return PwdEdt;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getBackHome() {
		return backHome;
	}

	// business libraries
	public void adminLogin(String USERNAME1, String PASSWORD) {
		UserEdt.sendKeys(USERNAME1);
		PwdEdt.sendKeys(PASSWORD);
		submit.click();
	}

}
