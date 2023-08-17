package com.tms.bookingpackage.java;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.tms.GenericUtility.ExcelUtility;
import com.tms.GenericUtility.WebDriverUtility;
import com.tms.objectrepository.AdminHomePage;
import com.tms.objectrepository.CreatePackagePage;

public class CreatePackageTest  {
	WebDriver driver;
	public void createTour() throws Throwable {
		
//		DatabaseUtility dlib = new DatabaseUtility();
//		JavaUtility jlib = new JavaUtility();
		ExcelUtility elib = new ExcelUtility();
//		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		

//		String URL = flib.getPropertyData("url");
//		String BROWSER = flib.getPropertyData("browser");
//		String USERNAME = flib.getPropertyData("username");
//		String PASSWORD = flib.getPropertyData("password");
//		String USERNAME1 = flib.getPropertyData("username1");
//
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		wlib.maximize(driver);
//		driver.get(URL);
//		wlib.waitCondition(driver);
//		TmsHomePage th = new TmsHomePage(driver);
//		th.adminLogin();
//		AdminLoginPage alp = new AdminLoginPage(driver);
//		alp.adminLogin(USERNAME1, PASSWORD);
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.tour();
		ahp.create();
		CreatePackagePage cp = new CreatePackagePage(driver);
		// cp.createTour("bengaluru", "couple", "lalbagh", "10", "nature", "food,soda");
		HashMap<String, String> getdata = elib.getMultipleExcelData("Package", 0, 1, driver);
		cp.getData(driver, getdata);
		wlib.scrollBarAction(driver);
		File file = new File(".\\src\\test\\resources\\friends.jpg");
		String absPath = file.getAbsolutePath();
		cp.packgImgpath(absPath);
		cp.createPackage();
		cp.actualResult("SUCCESS");
	}
}
//create object for fileinputstream
//FileInputStream fis=new FileInputStream("./src/test/resources/SmgCommondata.properties");
////create object of properties class
//Properties pObj=new Properties();
////load the file
//pObj.load(fis);
////get the values using key

//driver.findElement(By.name("username")).sendKeys(USERNAME1);
//driver.findElement(By.name("password")).sendKeys(PASSWORD);
//driver.findElement(By.name("login")).click();
//driver.findElement(By.xpath("//span[text()=' Tour Packages']")).click();
//driver.findElement(By.xpath("//a[text()='Create']")).click();

//HashMap<String, String> map=new HashMap<String, String>();
//for(int i=0;i<rowCount;i++) {
//String key = wb.getSheet("Package").getRow(i).getCell(0).getStringCellValue();
//String value = wb.getSheet("Package").getRow(i).getCell(1).getStringCellValue();
//map.put(key, value);
//}
//for(Entry<String, String> set: map.entrySet()) {
//driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
//
//}	

//driver.findElement(By.id("packageimage")).sendKeys(absPath);
//String expResult="SUCCESS";
//WebElement actResult = driver.findElement(By.xpath("//strong[text()='SUCCESS']"));
//String text = actResult.getText();
//if(expResult.contains(text)) {
//	System.out.println("Package has been created successfully");
//}
//else {
//	System.out.println("package not created");
//}
