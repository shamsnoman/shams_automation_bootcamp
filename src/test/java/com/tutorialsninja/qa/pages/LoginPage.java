package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "input-email")
	private WebElement login_EmailEditBox;
	
	public void login_EmailEdit(String email) {
		login_EmailEditBox.sendKeys(email);
	}
	
	
	@FindBy(id = "input-password")
	private WebElement login_PasswordEditBox;
	
	public void login_PasswordEdit(String password) {
		login_PasswordEditBox.sendKeys(password);
	}
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement login_SubmitButton ;
	
	
	public void login_Submit() {
		login_SubmitButton.click();
	}
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement login_NoMatchwarningMessageElement ;
	
	public String login_NoMatchwarningMessage() {
		String message = login_NoMatchwarningMessageElement.getText();
		return message;
	}
	

}















