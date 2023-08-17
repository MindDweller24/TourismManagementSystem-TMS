package com.Pratice.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantra {

	public static void main(String[] args) throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		String expdata = "RMG_3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().window().maximize();
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.name("projectName")).sendKeys("RMG_3");
		driver.findElement(By.name("createdBy")).sendKeys("nareshIT");
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='status']"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "select project_name from projects;";
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String actdata = result.getString(1);
			if (actdata.equalsIgnoreCase(expdata)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("project created successfully");
		} else {
			System.out.println("not created");
		}

	}

}
