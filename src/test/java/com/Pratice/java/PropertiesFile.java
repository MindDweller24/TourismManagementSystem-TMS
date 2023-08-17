package com.Pratice.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public abstract class PropertiesFile {

	public static void main(String[] args) throws IOException {
		// create object for fileinputstream
		FileInputStream fis = new FileInputStream(".//src\\test\\resources\\SmgCommondata.properties");
		// create object of properties class
		Properties pObj = new Properties();
		// load the file
		pObj.load(fis);
		// get the values using key
		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		String USERNAME1 = pObj.getProperty("username1");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(USERNAME1);

	}

}
