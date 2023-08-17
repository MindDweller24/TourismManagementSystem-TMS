package com.Pratice.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.tms.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookHotelMMT {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.maximize(driver);
		driver.get(
				"https://www.booking.com/index.en-gb.html?aid=2311236;label=en-in-booking-desktop-uSk_D31PSw6uA7*0m2JzPwS652796016141:pl:ta:p1:p2:ac:ap:neg:fi:tikwd-5887630340:lp9062009:li:dec:dm;ws=&gclid=CjwKCAjw5remBhBiEiwAxL2M9xThPHqOV6Rj4lZONK93AF4xUMZQ6hqQ75dXWlzUqy5mjKpsFz-0MxoCKEsQAvD_BwE");
//	    driver.navigate().refresh();
		wlib.waitCondition(driver);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveByOffset(40, 40).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Flight + Hotel')]")).click();
		driver.findElement(By.xpath(
				"//span[text()='Round-trip' and @class='Spanstyled__SpanStyled-sc-16tp9kb-0 gBHCUV kite-js-Span Box-sc-kv6pi1-0 jYjFkI']"))
				.click();
		driver.findElement(By.xpath("//span[text()='One-way']")).click();
		Thread.sleep(2000);
//	Select s=new Select(driver.findElement(By.xpath("//span[text()='Economy']")));
//	s.selectByVisibleText("Premium economy");
		driver.findElement(By.xpath("//span[text()='Flying from']")).click();
		driver.findElement(By.xpath("//li[@data-text='Bangalore']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flying to']")).sendKeys("Delhi");

	}

}
