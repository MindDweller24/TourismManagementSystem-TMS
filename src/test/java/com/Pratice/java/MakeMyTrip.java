package com.Pratice.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	public static void main(String[] args) {
		String MonthAndYear = "July 2023";
		int date = 29;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String actualDate = "//div[text()='" + MonthAndYear
				+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date + "']";
		driver.findElement(By.xpath(actualDate)).click();
	}

}
