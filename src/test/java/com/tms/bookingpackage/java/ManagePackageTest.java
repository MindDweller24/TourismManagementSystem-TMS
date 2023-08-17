package com.tms.bookingpackage.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.GenericUtility.DatabaseUtility;
import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.FileUtility;
import com.tms.GenericUtility.JavaUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.objectrepository.AdminHomePage;
import com.tms.objectrepository.AdminLoginPage;
import com.tms.objectrepository.ManagePackagesPage;
import com.tms.objectrepository.UpdatePackagePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManagePackageTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver;
		DatabaseUtility dlib = new DatabaseUtility();
		JavaUtility jlib = new JavaUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String URL = flib.getPropertyData("url1");
		String BROWSER = flib.getPropertyData("browser");
		String USERNAME = flib.getPropertyData("username1");
		String PASSWORD = flib.getPropertyData("password");

		// Launching the browser
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		wlib.maximize(driver);
		driver.get(URL);
		wlib.waitCondition(driver);
		AdminLoginPage ap = new AdminLoginPage(driver);
		ap.adminLogin(USERNAME, PASSWORD);
		AdminHomePage ah = new AdminHomePage(driver);
		ah.tour();
		ah.updatePkg();
		ManagePackagesPage mp = new ManagePackagesPage(driver);
		mp.details();
		UpdatePackagePage up = new UpdatePackagePage(driver);
		up.updatePackage();
		wlib.scrollBarAction(driver);
		up.actualResult("UPDATE");
	}
}

//driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
//driver.findElement(By.name("username")).sendKeys(USERNAME);
//driver.findElement(By.xpath("//input[@class='password']")).sendKeys(PASSWORD);
//driver.findElement(By.xpath("//input[@type='submit']")).click();

//driver.findElement(By.xpath("//a[text()='Manage']")).click();
// driver.findElement(By.xpath("//button[@type='button']")).click();

//WebElement click = driver.findElement(By.xpath("//span[text()=' Tour Packages']"));
//wlib.mousehover(driver, click);

//WebElement name = driver.findElement(By.id("packagename"));
//name.clear();
//name.sendKeys("Manali");

//String text = driver.findElement(By.xpath("//button[@type='submit']")).getText();
//System.out.println(text);
//if(expect.equals(text)) {
//	System.out.println("Package updated successfully");
//}
//else {
//	System.out.println("Package not updated successfully");
//}
