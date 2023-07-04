package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='account' and @value='guest']")
    private WebElement checkOut_GuestRadioButton;
	
	public void checkOut_GuestRadioButtonClick() {
		checkOut_GuestRadioButton.click();
	}
	
	@FindBy( xpath = "//input[@id='button-account']")
	private WebElement checkOut_CheckOutContinuebutton;
	
	public void checkOut_CheckOutContinuebuttonClick() {
		checkOut_CheckOutContinuebutton.click();
	}
	
	@FindBy( xpath = "//input[@name='agree' and @value='1']")
	private WebElement checkOut_TermsCheckBox;
	
	public void checkOut_TermsCheckBoxClick() {
		checkOut_TermsCheckBox.click();
	}
	
	@FindBy( xpath = "//input[@id='button-payment-method']")
	private WebElement checkOutPaymentContinuebtn;
	
	public void checkOutPaymentContinuebtnClick() {
		checkOutPaymentContinuebtn.click();
	}
	
	@FindBy( css = ".alert.alert-danger.alert-dismissible")
	private WebElement checkOut_WarningElement;
	
	public String  checkOut_WarningElementGetText() {
		String msg = checkOut_WarningElement.getText();
		return msg;
	}
	
}



















