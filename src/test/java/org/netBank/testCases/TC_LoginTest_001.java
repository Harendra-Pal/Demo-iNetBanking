package org.netBank.testCases;

import java.io.IOException;
import java.util.function.Function;

import org.netBank.pageObjects.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		logger.info("URL Opened");
		loginPage lp = new loginPage(driver);
		lp.logintoWebPage(username, password);
		logger.info("Username , Password given and Clicked on Login");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		Function<WebDriver, String> HomePageTitle = new Function<WebDriver, String>() { 
			public String apply(WebDriver driver) {
				return driver.getTitle();
			}};
		wait.until(HomePageTitle);
		System.out.println(driver.getTitle());

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true, "Passed");
			logger.info("TestCase Passed");
		} else {
			System.out.println("else entered");
			logger.info("Test Case Failed");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
		System.out.println("result on screen");
	}

}
