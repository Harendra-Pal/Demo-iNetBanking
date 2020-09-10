package org.netBank.testCases;

import java.io.IOException;
import org.netBank.pageObjects.addCustomer;
import org.netBank.pageObjects.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_003 extends BaseClass{
	
	@Test	
	public void addNewCustomer() throws InterruptedException, IOException 	{	
		loginPage lp = new loginPage(driver);
		lp.logintoWebPage(username, password);
		logger.info("Username , Password given and Clicked on Login");
		Thread.sleep(5000);
		driver.switchTo().activeElement();
		
		addCustomer addNewCust = new addCustomer(driver);
		addNewCust.addNewCust();
		logger.info("Customer Info gonna Input");
		addNewCust.CustName("Harendra Pal");
		addNewCust.CustGender("male");
		addNewCust.CustDOB("10", "11", "1989");
		Thread.sleep(5000);
		addNewCust.CustADD("Bharat");
		addNewCust.custCity("New Delhi");
		addNewCust.custState("Delhi");
		addNewCust.custPin("110092");
		addNewCust.custPhone("9999145185");
		addNewCust.custEmail(randomString()+"@gmail.com");
		addNewCust.custPassword("abcdef");
		addNewCust.clickSubmit();
		Thread.sleep(5000);
		
		logger.info("Validation Part Started.....");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			logger.info("Test case passed: Added New Customer");
			Assert.assertTrue(true);
		} else {logger.info("Test case failed: unable to create new Customer");
		captureScreen(driver, "addNewCustomer");
		Assert.assertTrue(false);
		}	
	}
}
