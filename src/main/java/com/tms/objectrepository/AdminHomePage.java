package com.tms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	// Declaring the WebElements
	@FindBy(xpath = "//i[@class='fa fa-angle-down']")
	private WebElement scrollbtn;
	@FindBy(xpath = "//a[@href='change-password.php']")
	private WebElement profilebtn;
	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement logoutbtn;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homebtn;
	@FindBy(xpath = "//span[text()=' Tour Packages']")
	private WebElement tourbtn;
	@FindBy(xpath = "//a[text()='Create']")
	private WebElement createbtn;
	@FindBy(xpath = "//a[text()='Manage']")
	private WebElement managebtn;
	
	// Initializing the WebElements
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Utilizing the WebElements
	public WebElement getScrollbtn() {
		return scrollbtn;
	}
	public WebElement getProfilebtn() {
		return profilebtn;
	}
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public WebElement getHomebtn() {
		return homebtn;
	}
	public WebElement getTourbtn() {
		return tourbtn;
	}
	public WebElement getCreatebtn() {
		return createbtn;
	}
	public WebElement getManagebtn() {
		return managebtn;
	}
	// business libraries
	public void login() {
		scrollbtn.click();
		profilebtn.click();
	}

	public void logout() {
		scrollbtn.click();
		logoutbtn.click();
	}

	public void home() {
		homebtn.click();

	}

	public void tour() {
		tourbtn.click();
	}

	public void create() {
		createbtn.click();
	}

	public void updatePkg() {
		managebtn.click();
	}

}
