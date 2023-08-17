package com.tms.bookingpackage.java;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tms.GenericUtility.FileUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.objectrepository.AdminLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAsAdminTest {
	public static void main(String[] args) throws IOException {
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		String URL = flib.getPropertyData("url1");
		String BROWSER = flib.getPropertyData("browser");
		String USERNAME = flib.getPropertyData("username1");
		String PASSWORD = flib.getPropertyData("password");
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		wlib.maximize(driver);
		driver.get(URL);
		wlib.waitCondition(driver);
		// login to app
		AdminLoginPage ap = new AdminLoginPage(driver);
		ap.adminLogin(USERNAME, PASSWORD);

	}
}

//get the data from property file
//FileInputStream fis=new FileInputStream(".//src\\\\test\\\\resources\\\\SmgCommondata.properties");
//Properties pObj=new Properties();
//pObj.load(fis);

//driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
//driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
//driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
//driver.findElement(By.xpath("//input[@type='submit']")).click();