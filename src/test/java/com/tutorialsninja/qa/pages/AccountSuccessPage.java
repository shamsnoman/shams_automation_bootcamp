package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	public WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement accountSuccess_AccountConfirmationElement;
	
	public String accountSuccess_AccountConfirmationText() {
		String text = accountSuccess_AccountConfirmationElement.getText();
		return text;
	}
	
	

}
