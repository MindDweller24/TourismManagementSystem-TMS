package com.Pratice.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakBooking {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-destination']")).click();
		driver.findElement(By.xpath("//span[text()='New Delhi, National Capital Territory of India, India']")).click();
		driver.findElement(By.xpath("//span[@class='sR_k-value']")).click();
		driver.findElement(By.xpath(
				"//div[text()='August 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[text()='2'][1]"))
				.click();
		driver.findElement(By.xpath("//span[@class='sR_k-date sR_k-mod-hide-arrows sR_k-mod-active']")).click();
		driver.findElement(By.xpath(
				"//div[text()='September 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[text()='7']"))
				.click();
		driver.findElement(By.xpath(
				"//button[@class='Iqt3 Iqt3-mod-bold Button-No-Standard-Style Iqt3-mod-variant-solid Iqt3-mod-theme-progress Iqt3-mod-shape-rounded-medium Iqt3-mod-shape-mod-default Iqt3-mod-spacing-default Iqt3-mod-size-large Iqt3-mod-animation-search']"))
				.click();

	}

}
