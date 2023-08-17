package com.Pratice.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommandPrompt {
	@Test

	public void readDataFromCommandLine() {
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		String USERNAME1 = System.getProperty("username1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME1);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
