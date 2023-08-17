package com.tms.bookingpackage.java;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tms.GenericUtility.DatabaseUtility;
import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.FileUtility;
import com.tms.GenericUtility.JavaUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.objectrepository.BookPackagePage;
import com.tms.objectrepository.MyTourHistoryPage;
import com.tms.objectrepository.TmsHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookAndCancelTest {
	public static void main(String[] args) throws IOException {
		DatabaseUtility dlib = new DatabaseUtility();
		JavaUtility jlib = new JavaUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String URL = flib.getPropertyData("url");
		String BROWSER = flib.getPropertyData("browser");
		String USERNAME = flib.getPropertyData("username");
		String PASSWORD = flib.getPropertyData("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		wlib.maximize(driver);
		driver.get(URL);
		wlib.waitCondition(driver);
		TmsHomePage th = new TmsHomePage(driver);
		th.userLogin(USERNAME, PASSWORD);// login to app
		BookPackagePage bp = new BookPackagePage(driver);
		bp.detailButton();
		wlib.scrollBarAction(driver);
		bp.bookPackage();
		bp.actualResult(":Booked Successfully ");
		MyTourHistoryPage mth = new MyTourHistoryPage(driver);
		mth.TourHistory();
		mth.CancelTour();
		wlib.acceptAlert(driver);
		mth.actualResult(":Booking Cancelled successfully ");
	}
}

//get the data from property file
//FileInputStream fis=new FileInputStream(".//src\\\\test\\\\resources\\\\SmgCommondata.properties");
//Properties pObj=new Properties();
//pObj.load(fis);

//driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
//driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(USERNAME);
//driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys(PASSWORD);
//driver.findElement(By.name("signin")).click();
//driver.findElement(By.xpath("//a[text()='Details']")).click();

//driver.findElement(By.id("datepicker")).click();
//driver.findElement(By.xpath("//a[text()='29']")).click();
//driver.findElement(By.id("datepicker1")).click();
//driver.findElement(By.xpath("//a[text()='31']")).click();
//driver.findElement(By.name("comment")).sendKeys("welcome");
//driver.findElement(By.xpath("//button[text()='Book']")).click();

//driver.findElement(By.xpath("//a[text()='My Tour History']")).click();
//driver.findElement(By.xpath("//table/tbody/tr[last()]/td/a[text()='Cancel']")).click();

//String expResult=":Booked Successfully ";
//WebElement actResult = driver.findElement(By.xpath("//div[text()=':Booked Successfully ']"));
//String text = actResult.getText();
//if(expResult.contains(text)) {
//	System.out.println("Booking not successfull");
//}
//else {
//	System.out.println("Booking successful");
//}

//String expctResult = ":Booking Cancelled successfully ";
//WebElement actualResult = driver.findElement(By.xpath("//div[text()=':Booking Cancelled successfully ']"));
//String resText = actualResult.getText();
//if(expctResult.contains(resText)) {
//	System.out.println("Booking cancel not successfull");
//}
//else {
//	System.out.println("Booking cancel successfully");
//}
//}