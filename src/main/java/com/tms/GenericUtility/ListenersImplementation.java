package com.tms.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
ExtentReports report;
ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"--->TestScript execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"--->passed");
		Reporter.log(MethodName+"---> testscript passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String FScript = result.getMethod().getMethodName();
		String FailedScript = FScript+new JavaUtility().getSystemdateInFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+FailedScript+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.log(Status.FAIL, FScript+"---->Failed Script");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(FailedScript);
		Reporter.log(FScript+"---->TestSCript failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---->Failed Script");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"---->TestSCript failed");
	}

	@Override
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-50");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("TMS");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-url", "http:localhost:8888/");
		report.setSystemInfo("reporter Name", "Sanat");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		//consolidate the report
		report.flush();
	}
	

}
