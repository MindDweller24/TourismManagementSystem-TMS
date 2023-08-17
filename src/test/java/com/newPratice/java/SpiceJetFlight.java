package com.newPratice.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetFlight {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//div[text()='From']")).sendKeys("banga");
		driver.findElement(By.xpath("(//input[@autocapitalize=\"sentences\" and @class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\" ])[2]")).sendKeys("delh");
		//driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		driver.findElement(By.xpath("//div[text()='2023' and text()='August ']/ancestor::div[@class='css-1dbjc4n r-18u37iz'][1]/descendant::div[text()='17']")).click();
		//driver.findElement(By.xpath("//div[text()='Return Date']")).click();
		driver.findElement(By.xpath("//div[text()='2023' and text()='September ']/ancestor::div[@class='css-1dbjc4n r-18u37iz'][1]/descendant::div[text()='14']")).click();
		driver.findElement(By.xpath("//div[text()='1 Adult']")).click();
		driver.findElement(By.xpath("(//div[@class=\"css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid\"])[2]")).click();
//		driver.findElement(By.xpath("//div[text()='Currency']")).click();
//		Select s=new Select(driver.findElement(By.xpath("//div[text()='Currency']")));
//		s.selectByVisibleText("USD");
//		driver.findElement(By.xpath("css-1dbjc4n")).click();
		driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep\"]/descendant::div[text()='INR']")).click();
		Thread.sleep(10);
		driver.findElement(By.xpath("//div[text()='USD']")).click();
		Thread.sleep(10);
//		WebElement element = driver.findElement(By.xpath("//div[text()='Search Flight']"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", element);
		WebElement ele = driver.findElement(By.xpath("//div[text()='Search Flight']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
		List<WebElement> result = driver.findElements(By.xpath("//div[@class=\"css-1dbjc4n r-1loqt21 r-13awgt0 r-18u37iz r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr\"]"));
		for(int i=0;i<result.size();i++) {
			String text = result.get(i).getText();
			System.out.print(text);
		}
		
		
		
		
		
	}

}
