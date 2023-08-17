package com.Pratice.java;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraBrokenLinks {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
		ArrayList<String> links = new ArrayList<String>();
		for (int i = 0; i < alllinks.size(); i++) {
			String check = alllinks.get(i).getAttribute("href");
			URL url = null;
			int statuscode = 0;
			try {
				url = new URL(check);
				HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
				statuscode = httpconnection.getResponseCode();
				if (statuscode >= 400) {
					links.add(check + "----->" + statuscode);
				}
			} catch (Exception e) {
				links.add(check + "----->" + statuscode);
			}
			System.out.println(links);
		}
		driver.close();
	}

}
