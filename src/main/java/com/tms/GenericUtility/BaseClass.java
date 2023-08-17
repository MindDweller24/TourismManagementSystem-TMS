package com.tms.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tms.objectrepository.AdminHomePage;
import com.tms.objectrepository.AdminLoginPage;
import com.tms.objectrepository.TmsHomePage;
import com.tms.objectrepository.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	 DatabaseUtility dlib = new DatabaseUtility();
	FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility jlib = new JavaUtility();
	

	@BeforeSuite
	public void config_Bs() throws Throwable {
		dlib.connectToDataBase();
		System.out.println("--connecting to DB--");
	}
    //@Parameters("BROWSER")
	@BeforeClass
	public void config_Bc() throws Throwable {
	String BROWSER = flib.getPropertyData("browser");
		if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(BROWSER.equalsIgnoreCase("chrome")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		System.out.println("--launch the browser");
		wlib.maximize(driver);
	}

	@BeforeMethod
	public void config_Bm() throws Throwable {
		String adminUSERNAME = flib.getPropertyData("username1");
		String userUSERNAME = flib.getPropertyData("username");
		
		String PASSWORD = flib.getPropertyData("password");
		String URL = flib.getPropertyData("url");
		driver.get(URL);
		wlib.waitCondition(driver);
		TmsHomePage th = new TmsHomePage(driver);
//		// login as user
//		th.userLogin(userUSERNAME, PASSWORD);
//		System.out.println("--login to app as user--");
//		 login as admin
		th.adminLogin();
		AdminLoginPage al = new AdminLoginPage(driver);
		al.adminLogin(adminUSERNAME, PASSWORD);
		System.out.println("--login to app as admin--");

	    


	}

	@AfterMethod
	public void config_Am() {
		// logout as admin
		AdminHomePage ap = new AdminHomePage(driver);
		ap.logout();
		System.out.println("--logout to app as admin--");
		//logout as user
//		UserHomePage uh=new UserHomePage(driver);
//		uh.logout();
//		System.out.println("--logout to app as user--");
	}

	@AfterClass
	public void config_Ac() {
		driver.quit();
		System.out.println("--close the browser--");
	}

	@AfterSuite
	public void config_As() throws Throwable {
		dlib.closeDatabase();
		System.out.println("--close the database--");
	}

}
