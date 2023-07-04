package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutRegistration {

	public WebDriver driver;
	
	public CheckOutRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	private WebElement checkReg_FirstName;
	
	public void checkReg_FirstNameEdit(String name) {
		checkReg_FirstName.sendKeys(name);
	}
	
	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	
	private WebElement checkReg_LastName;
	
	public void checkReg_LastNameEdit(String name) {
		checkReg_LastName.sendKeys(name);
	}
	
	@FindBy(xpath = "//input[@id='input-payment-email']")
	private WebElement checkReg_Email;
	
	public void checkReg_EmailEdit(String email) {
		checkReg_Email.sendKeys(email);
	}
	
	@FindBy(xpath = "//input[@id='input-payment-telephone']")
	private WebElement checkReg_Telephone ;
	public void checkReg_TelephoneEdit(String phone) {
		checkReg_Telephone.sendKeys(phone);
	}
	
	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	private WebElement checkReg_Address1;
	public void checkReg_Address1Edit(String address) {
		checkReg_Address1.sendKeys(address);
	}
	
	@FindBy(xpath = "//input[@id='input-payment-city']")
	private WebElement checkReg_City;
	
	public void checkReg_CityEdit(String city) {
		checkReg_City.sendKeys(city);
	}
	
	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	private WebElement checkReg_PostCode;
	
	public void checkReg_PostCode(String code) {
		checkReg_PostCode.sendKeys(code);
	}
	
	@FindBy(xpath = "//input[@id='button-guest']")
	private WebElement checkReg_RegisterContinueBtn;
	
	public void checkReg_RegisterContinueBtnClick() {
		checkReg_RegisterContinueBtn.click();
	}
	
	
	
//	 = driver.findElement(By.id());
	
//	
	
	@FindBy(id = "input-payment-country")
	private WebElement checkReg_Country;
	
	public void checkReg_CountrySelect() {
		Select select = new Select(checkReg_Country);
		select.selectByVisibleText("United States");
	}
	
	@FindBy(id="input-payment-zone")
	private WebElement checkReg_Zone;
	
	public void checkReg_ZoneSelect() {
		Select select1 = new Select(checkReg_Zone);
		select1.selectByVisibleText("Michigan");
	}
	
}






















