package com.Pratice.java;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokelLinks {
	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		ArrayList<String> links = new ArrayList<String>();
		for (int i = 0; i < allLinks.size(); i++) {
			String checkLinks = allLinks.get(i).getAttribute("href");
			URL url = null;
			int statusCode = 0;
			try {
				url = new URL(checkLinks);
				HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
				statusCode = httpConnection.getResponseCode();
				if (statusCode >= 400) {
					links.add(checkLinks + "------->" + statusCode);
				}
			} catch (Exception e) {
				links.add(checkLinks + "------>" + statusCode);
			}
			System.out.println(links);

		}
	}
}