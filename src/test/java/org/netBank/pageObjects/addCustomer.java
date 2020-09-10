package org.netBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class addCustomer {
	WebDriver ldriver;
	
	public addCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using= "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addNewCust;
	
	@FindBy(how = How.NAME, using= "name")
	@CacheLookup
	WebElement custName;
	
	@FindBy(how = How.NAME, using= "rad1")
	@CacheLookup
	WebElement custGender;
	
	@FindBy(how = How.ID_OR_NAME, using= "dob")
	@CacheLookup
	WebElement txtDOB;
	
	@FindBy(how = How.NAME, using= "addr")
	@CacheLookup
	WebElement txtaddr;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtTeleNo;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmailID;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void addNewCust() {addNewCust.click();}
	public void CustName(String name) {custName.sendKeys(name);}
	public void CustGender(String gender) {custGender.click();}
	public void CustDOB(String dd, String mm, String yyyy) {txtDOB.sendKeys(dd); txtDOB.sendKeys(mm); txtDOB.sendKeys(yyyy);}
	public void CustADD(String addr) {txtaddr.sendKeys(addr);}
	public void custCity(String city) {txtCity.sendKeys(city);}
	public void custState(String state) {txtState.sendKeys(state);}
	public void custPin(String pin) {txtPin.sendKeys(String.valueOf(pin));}
	public void custPhone(String teleNo) {txtTeleNo.sendKeys(String.valueOf(teleNo));}
	public void custEmail(String email) {txtEmailID.sendKeys(email);}
	public void custPassword(String pwd) {txtPassword.sendKeys(pwd);}
	public void clickSubmit() {btnSubmit.click();}
	
	
	
}
