package com.tms.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class WebDriverUtility {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitCondition(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void waitTillCondition(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void select(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void select(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void mousehover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	public void dragAnddrop(WebDriver driver, WebElement src, WebElement desc) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, desc);
	}

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	public void enterKeyPress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void enterKey(WebDriver driver) throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	public void enterRelease(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement adress) {
		driver.switchTo().frame(adress);
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToWindow(WebDriver driver, String partialTitle) {
		// step 1:use get window handles to capture all the windows id
		Set<String> windows = driver.getWindowHandles();
		// step 2:iterate through the windows
		Iterator<String> it = windows.iterator();
		// step 3:check whether their is next window
		while (it.hasNext()) {
			// step 4:capture current window id
			String winId = it.next();
			// step 5:switch to current window and get the title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			// step 6:check whether current window is expected
			if (currentWinTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	//public void getScreenShot(WebDriver driver) {
		//TakesScreenshot ts = (TakesScreenshot) driver;

//	}

	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}

	public void scrollBarAction(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scroll(0," + y + ")", element);
	}

}
