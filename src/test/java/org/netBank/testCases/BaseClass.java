package org.netBank.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.netBank.utilities.ReadConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseURL = readconfig.getvalue("BaseURL");
	public String username = readconfig.getvalue("username"); 
	public String password = readconfig.getvalue("password");
	
	public static RemoteWebDriver driver;
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.geckodriver.driver", "./Drivers\\geckodriver.exe");
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.iedriver().setup();
//			System.setProperty("webdriver.ie.driver", "./Drivers\\IEDriverServer.exe");
			driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(BaseURL);
		
		
		logger = Logger.getLogger("NetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File target = new File(System.getProperty("user.dir")+ "/ScreenShots/" +tname+timeStamp+".png");
		FileUtils.copyFile(screen, target);
		System.out.println("ScreenShot Captured");
	}
	public String randomString() {
		String randomSTR = RandomStringUtils.randomAlphabetic(8);
		return randomSTR;
	}
	public static String randomNum() {
		String randomNum = RandomStringUtils.randomNumeric(8);
		return randomNum;
	}
}
