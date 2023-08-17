package com.Pratice.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProKabaddi {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String team = "Bengaluru Bulls";
		String teamName = driver.findElement(By.xpath("//p[text()='Bengaluru Bulls']")).getText();
		String played = driver.findElement(By.xpath("//p[text()='" + team
				+ "']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']"))
				.getText();
		String won = driver.findElement(By.xpath("//p[text()='" + team
				+ "']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-won']"))
				.getText();
		String lost = driver.findElement(By.xpath("//p[text()='" + team
				+ "']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-lost']"))
				.getText();
		String draw = driver.findElement(By.xpath(
				"//p[text()='Bengaluru Bulls']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-draw']"))
				.getText();
		String scoreDiff = driver.findElement(By.xpath(
				"//p[text()='Bengaluru Bulls']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data score-diff']"))
				.getText();
		String form = driver.findElement(By.xpath(
				"//p[text()='Bengaluru Bulls']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data form']"))
				.getText();
		System.out.println(teamName + " : " + "played=" + played + " won=" + won + " lost=" + lost + " draw=" + draw
				+ " scorrDiff=" + scoreDiff + " form=" + form);
		driver.close();
	}

}
