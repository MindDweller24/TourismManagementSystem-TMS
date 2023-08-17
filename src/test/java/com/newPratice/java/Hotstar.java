package com.newPratice.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tms.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

public class Hotstar {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.maximize(driver);
		driver.get("https://www.hotstar.com/in/home?ref=%2Fin");
		wlib.waitCondition(driver);
		driver.findElement(By.xpath("//img[@alt=\"National Treasure: Edge of History\"]")).click();
		
			
			
	
		
	}
	
		
		
	

}
