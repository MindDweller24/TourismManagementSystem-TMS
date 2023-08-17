package com.tms.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePackagePage {
	// declaring the WebElement

	@FindBy(id = "packagename")
	private WebElement Packagename;

	@FindBy(id = "packagetype")
	private WebElement Packagetype;

	@FindBy(id = "packagelocation")
	private WebElement PackageLoc;

	@FindBy(id = "packageprice")
	private WebElement Packageprice;

	@FindBy(id = "packagefeatures")
	private WebElement Packagefeature;

	@FindBy(id = "packagedetails")
	private WebElement Packagedetails;

	@FindBy(id = "packageimage")
	private WebElement Packageimg;

	@FindBy(name = "submit")
	private WebElement Submit;

	@FindBy(xpath = "//button[text()='Reset']")
	private WebElement Reset;
	@FindBy(xpath = "//strong[text()='SUCCESS']")
	private WebElement actRes;

	// initializing the WebElement
	public CreatePackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilizing the WebElements
	public WebElement getPackagename() {
		return Packagename;
	}

	public WebElement getPackagetype() {
		return Packagetype;
	}

	public WebElement getPackageLoc() {
		return PackageLoc;
	}

	public WebElement getPackageprice() {
		return Packageprice;
	}

	public WebElement getPackagefeature() {
		return Packagefeature;
	}

	public WebElement getPackagedetails() {
		return Packagedetails;
	}

	public WebElement getPackageimg() {
		return Packageimg;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getReset() {
		return Reset;
	}

	public WebElement getActRes() {
		return actRes;
	}

	// business libraries
	public void createTour(String Name, String Type, String Loc, String Price, String Features, String Details) {
		Packagename.sendKeys(Name);
		Packagetype.sendKeys(Type);
		PackageLoc.sendKeys(Loc);
		Packageprice.sendKeys(Price);
		Packagefeature.sendKeys(Features);
		Packagedetails.sendKeys(Details);
		Packageimg.click();

	}

	public void createPackage() {
		Submit.click();
	}

	public void packageimg() {
		Packageimg.click();
	}

	public void packgImgpath(String path) {
		Packageimg.sendKeys(path);
	}

	public void actualResult(String expdata) {
		String text = actRes.getText();
		Assert.assertEquals(expdata, text);
		System.out.println("Package has been created successfully");
//		if (text.contains(expdata)) {
//			System.out.println("Package has been created successfully");
//		} else {
//			System.out.println("package not created");
//		}
	}
	public void getData(WebDriver driver,HashMap<String, String> hs) {
		
		
		for (Entry<String, String> set : hs.entrySet()) {
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
		
	}

}
