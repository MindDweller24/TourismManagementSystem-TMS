package com.Pratice.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboTest1 {
	@Test
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 dRQhOp']")).click();
		driver.findElement(By.xpath("//span[@class='sc-12foipm-21 lerOcM fswDownArrow']")).click();
		String actualdate = "//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='28']";
		String nextarrow = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
		for (;;) {
			try {
				driver.findElement(By.xpath(actualdate));
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath(nextarrow));
			}
			driver.findElement(By.xpath("//span[text()='Done']")).click();
		}
	}

}
