package com.Pratice.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tms.GenericUtility.WebDriverUtility;

public class ActiTime {
	@Test

	public void readDatafromCMD() {

		String BROWSER = System.getProperty("browser");
		String URl = System.getProperty("Url");
		String USERNAME = System.getProperty("un");
		String PASSWORD = System.getProperty("pwd");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URl);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();

	}

}
