package com.Pratice.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboTest {
	public static void main(String[] args) {
		String MonthAndYear = "September 2023";
		int date = 25;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 dRQhOp']")).click();
		driver.findElement(By.xpath("//span[@class='sc-12foipm-21 lerOcM fswDownArrow']")).click();
		String actualDate = "//div[text()='" + MonthAndYear
				+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date + "']";
		String nextArrow = "//span[@aria-label='Next Month']";
		for (;;) {
			try {
				driver.findElement(By.xpath(actualDate)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
	}
}
