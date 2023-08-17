package com.Pratice.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloCmd {
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String Link = System.getProperty("url2");
		driver.get(Link);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
