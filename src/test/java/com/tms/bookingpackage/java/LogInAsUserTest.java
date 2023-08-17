package com.tms.bookingpackage.java;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tms.GenericUtility.FileUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.objectrepository.TmsHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInAsUserTest {

	public static void main(String[] args) throws IOException {
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		String URL = flib.getPropertyData("url");
		String BROWSER = flib.getPropertyData("browser");
		String USERNAME = flib.getPropertyData("username");
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
		TmsHomePage th = new TmsHomePage(driver);
		th.userLogin(USERNAME, PASSWORD);

	}
}
