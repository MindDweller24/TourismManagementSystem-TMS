package com.Pratice.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingCountryWithMatches {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teams = driver.findElements(By.xpath(
				"//td[@class='rankings-block__banner--team-name']/parent::tr[@class='rankings-block__banner']/following-sibling::tr[@class='table-body']/child::td[@class='table-body__cell rankings-table__team']"));
		List<WebElement> matches = driver.findElements(By.xpath("//td[3]"));
		for (int i = 0; i < teams.size(); i++) {
			for (int j = 0; j < matches.size(); j++) {
				System.out.print(matches.get(j).getText());
			}
			System.out.print(teams.get(i).getText());
		}

	}

}
