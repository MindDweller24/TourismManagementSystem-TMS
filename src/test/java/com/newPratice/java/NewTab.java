package com.newPratice.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab {
	public static void main(String[] args) {
		
		  WebDriverManager.chromedriver().setup();
  		WebDriver driver = new ChromeDriver();
	      driver.get("https://www.google.com/");
	      driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
//	      String newTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	      List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
			for (int i = 0; i < allLinks.size(); i++) {
				allLinks.get(i).sendKeys();
			}
//	     WebDriverManager.chromedriver().setup();
//	  		WebDriver driver = new ChromeDriver();
//	  		driver.get("https://www.google.com/");
//	  		((JavascriptExecutor)driver).executeScript("window.open()");
//	  		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//	  		driver.switchTo().window(tabs.get(tabs.size()-1));
//	  		driver.get("https://www.facebook.com/");
//	  		driver.quit();
	   
		      driver.get(null);
		     
	
		   }
		
}
	

