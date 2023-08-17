package com.newPratice.java;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssertTest {
	@Test
	public void hardAssertTitle() {
		String actualResult = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println("--step-1--");
		System.out.println("--step-2--");
		System.out.println("--step-3--");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		String title = driver.getTitle();
		System.out.println(title);
		assertNotEquals(actualResult, title);
		System.out.println("--step-4--");
		System.out.println("--step-5--");
	}
	@Test
	public void sample() {
		System.out.println("--step-6--");
		System.out.println("--step-7--");
		int a=10;
		Assert.assertNull(a);
		System.out.println("--step-8--");
		System.out.println("--step-9--");
		
	}
}
