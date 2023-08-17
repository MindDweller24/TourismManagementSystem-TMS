package com.tms.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UserHomePage {

	// Declaring the WeblElements
	@FindBy(xpath = "//a[text()='/ Logout']") // a[text()='Issue Tickets']
	private WebElement logoutbtn;
	@FindBy(xpath = "//a[text()='Issue Tickets']")
	private WebElement issuebtn;
	@FindBy(xpath = "//a[text()='My Tour History']")
	private WebElement historybtn;
	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement chngpwdbtn;
	@FindBy(xpath = "//a[text()='My Profile']")
	private WebElement profilebtn;
	@FindBy(xpath = "//a[text()=' / Write Us ']")
	private WebElement Writeusbtn;
	@FindBy(xpath = "//a[text()='Tour Packages']")
	private WebElement Tourbtn;
	@FindBy(xpath = "//a[text()='Details']")
	private WebElement detailsbtn;
	@FindBy(id = "country")
	private WebElement drpdwn;
	@FindBy(xpath = "//h4[text()='  Info successfully submited ']")
	private WebElement actRes;
	@FindBy(name = "description")
	private WebElement desc;
	@FindBy(name = "submit")
	private WebElement submit;
	@FindBy(xpath = "//table//tbody//tr[last()]//td[4]")
	private WebElement data;
	@FindBy(xpath = "//table//tbody//tr[last()]//td[3]")
	private WebElement data1;

	// Initializing the WebElements
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Utilizing the WebElements

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public WebElement getIssuebtn() {
		return issuebtn;
	}

	public WebElement getHistorybtn() {
		return historybtn;
	}

	public WebElement getChngpwdbtn() {
		return chngpwdbtn;
	}

	public WebElement getProfilebtn() {
		return profilebtn;
	}

	public WebElement getWritebtn() {
		return Writeusbtn;
	}

	public WebElement getTourbtn() {
		return Tourbtn;
	}

	public WebElement getDetailsbtn() {
		return detailsbtn;
	}

	public WebElement getDrpdwn() {
		return drpdwn;
	}

	public WebElement getActRes() {
		return actRes;
	}

	public WebElement getDesc() {
		return desc;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public String getIssueDesc() {
		return issueDesc;
	}

	public String getIssueName() {
		return issueName;
	}

	// business libraries
	public void logout() {
		logoutbtn.click();
	}

	public void issueTicket() {
		issuebtn.click();
	}

	public void tourHistory() {
		historybtn.click();
	}

	public void changePwd() {
		chngpwdbtn.click();
	}

	public void writeUs() {
		Writeusbtn.click();
	}

	public void tourPkg() {
		Tourbtn.click();
	}

	public void details() {
		detailsbtn.click();
	}

	String issueDesc = "money deducted";
	String issueName = "Booking Issues";

	public void writeUsDrpdwn(WebDriver driver) {
		drpdwn.click();
		Select obj = new Select(drpdwn);
		obj.selectByVisibleText(issueName);
		desc.sendKeys(issueDesc);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	public void actualResult(String expData) {
		String text = actRes.getText();
		Assert.assertEquals(expData, text);
		System.out.println(text);
//		if (text.contains(expData)) {
//			System.out.println("issue not submited");
//		} else {
//			System.out.println("issue submited");
//		}
	}

	public void checkIssueDesc(WebDriver driver) {
//			String data = driver.findElement(By.xpath("//table//tbody//tr[last()]//td[4]")).getText();
//			String data1=driver.findElement(By.xpath("//table//tbody//tr[last()]//td[3]")).getText();
		String issue = data.getText();
		String description = data1.getText();
		Assert.assertEquals(issue, issueDesc);
		Assert.assertEquals(description, issueName);
		System.out.println("issue created successfully");
//		if (issue.contains(issueDesc) && description.contains(issueName)) {
//			System.out.println("issue created successfully");
//		} else {
//			System.out.println("issue not created successfully");
//		}
	}
}
