package com.tms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePackagePage {
//declaring the webElements
	@FindBy(id = "packagename")
	private WebElement pkgname;

	@FindBy(id = "packagetype")
	private WebElement pkgtype;

	@FindBy(id = "packagelocation")
	private WebElement pkgloc;

	@FindBy(id = "packageprice")
	private WebElement pkgprice;

	@FindBy(id = "packagefeatures")
	private WebElement pkgfeatures;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement actResult;

	// initializing the WebElements
	public UpdatePackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Utilizing the WebElements

	public WebElement getPkgname() {
		return pkgname;
	}

	public WebElement getPkgtype() {
		return pkgtype;
	}

	public WebElement getPkgloc() {
		return pkgloc;
	}

	public WebElement getPkgprice() {
		return pkgprice;
	}

	public WebElement getPkgfeatures() {
		return pkgfeatures;
	}

	public WebElement getActResult() {
		return actResult;
	}

	// business libraries
	public void updatePackage() {
		pkgname.clear();
		pkgname.sendKeys("Kerela");
		pkgprice.clear();
		pkgprice.sendKeys("300");
	}
@Test
	public void actualResult(String expData) {
		String text = actResult.getText();
		Assert.assertEquals(expData, text);
		System.out.println("package updated successfully");
//		if (text.contains(expData)) {
//			System.out.println("package updated successfully");
//		} else {
//			System.out.println("package not updated ");
//		}
	}
}
