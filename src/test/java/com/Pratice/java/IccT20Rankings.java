package com.Pratice.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccT20Rankings {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> allData = driver
				.findElements(By.xpath("//span[text()='Team']/ancestor::table[@class='table']//tr[*]"));
		System.out.println(allData.size());
		for (int i = 0; i < allData.size(); i++) {
			System.out.println(allData.get(i).getText());
		}
		driver.close();
	}

}
