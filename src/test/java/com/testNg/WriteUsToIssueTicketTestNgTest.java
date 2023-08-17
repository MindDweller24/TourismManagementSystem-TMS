package com.testNg;

import org.testng.annotations.Test;

import com.tms.GenericUtility.BaseClass;
import com.tms.objectrepository.UserHomePage;

public class WriteUsToIssueTicketTestNgTest extends BaseClass {
	@Test
	public void dataFlowInUser() {
		UserHomePage uh = new UserHomePage(driver);
		uh.writeUs();
		uh.writeUsDrpdwn(driver);
		uh.actualResult("");
		uh.issueTicket();
		uh.checkIssueDesc(driver);
	}

}
