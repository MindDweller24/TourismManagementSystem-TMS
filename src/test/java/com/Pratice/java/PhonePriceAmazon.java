package com.Pratice.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhonePriceAmazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> names = driver
				.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		System.out.println(names.size());
		List<WebElement> prices = driver
				.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i).getText();
			String price = prices.get(i).getText();

			String actPrice = price.replaceAll(" ,", "");
			System.out.println(name + "=====>" + actPrice);

		}
		driver.close();
	}

}
