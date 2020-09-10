package org.netBank.testCases;

import java.io.IOException;

import org.netBank.pageObjects.loginPage;
import org.netBank.utilities.XLUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginTest_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws IOException {
		loginPage lp = new loginPage(driver);
		lp.logintoWebPage(user, pwd);
		logger.info("Clicked Login with Given Username and Password");
//		Thread.sleep(5000);
		
		if (isAlertPresent() == true) {
//			captureScreen(driver, "AlertPresent");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertFalse(false);
		} else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.ClickLogout();
//			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
						return true;
		} catch (Exception e) {		return false;		}
	}
	
	@DataProvider(name = "LoginData")
	String[][] getdata() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/org/netBank/testDatas/LoginData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colNum = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rowNum][colNum];
		for(int i =1; i<=rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
