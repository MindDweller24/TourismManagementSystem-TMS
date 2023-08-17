package com.Pratice.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToApp {

	public static void main(String[] args) throws IOException {
		// create object for fileinputstream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\SmgCommondata.properties");
		// create object of properties class
		Properties pObj = new Properties();
		// load the file
		pObj.load(fis);
		// get the values using key
		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();

	}

}
