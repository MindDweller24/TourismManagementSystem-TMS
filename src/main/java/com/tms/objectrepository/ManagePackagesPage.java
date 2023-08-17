package com.tms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePackagesPage {
	// Declaring the WebEements
	@FindBy(xpath = "//button[@type='button']")
	private WebElement viewDetailsbtn;

//Initializing the WebElements
	public ManagePackagesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//utilizing the WebElements
	public WebElement getViewDetailsbtn() {
		return viewDetailsbtn;
	}

//business libraries
	public void details() {
		viewDetailsbtn.click();
	}
}
