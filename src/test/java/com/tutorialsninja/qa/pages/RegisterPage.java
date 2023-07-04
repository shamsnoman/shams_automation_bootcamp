package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy( id= "input-firstname")
	private WebElement register_FirstName;
	
	public void register_firstName(String name) {
		register_FirstName.sendKeys(name);
	}
	
	@FindBy( id= "input-lastname")
	private WebElement register_LastName;
	
	public void register_lastName(String name) {
		register_LastName.sendKeys(name);
	}
	
	@FindBy(id = "input-email")
	private WebElement register_EmailId ;
	
	public void register_EmailId(String email) {
		register_EmailId.sendKeys(email);
	}
	
	@FindBy(id = "input-telephone")
	private WebElement register_TelephoneNumber;
	
	public void register_TelephoneNumber(String telephone) {
		register_TelephoneNumber.sendKeys(telephone);
	}
	
	@FindBy(id = "input-password")
	private WebElement register_PasswordId;
	
	public void register_passwordId(String password) {
		register_PasswordId.sendKeys(password);
	}
	
	@FindBy(id = "input-confirm")
	private WebElement register_ConfirmPasswordId;
	
	public void register_ConfirmPasswordId(String confirmpassword) {
		register_ConfirmPasswordId.sendKeys(confirmpassword);
	}
	
	
	@FindBy( xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement register_SubscribeYesButton;
	public void register_SubscribeYesButtonClick() {
		register_SubscribeYesButton.click();
	}
	
	
	@FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
	private WebElement register_PolicyCheckbox;
	
	public void register_PolicyCheckboxClick() {
		register_PolicyCheckbox.click();
	}
	
	@FindBy(css = ".btn.btn-primary")
	private WebElement register_ContinueButton;
	
	public void register_ContinueButtonClick() {
		register_ContinueButton.click();
	}
	
	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement register_MissingFirstName;
	
	public String register_MissingFirstNameText() {
		String text = register_MissingFirstName.getText();
		return text;
	}

	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement register_MissingLastName;
	
	public String register_MissingLastNameText() {
		String text = register_MissingLastName.getText();
		return text;
	}
	
	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement register_MissingEmail;
	
	public String register_MissingEmailText() {
		String text = register_MissingEmail.getText();
		return text;
	}
	
	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement register_MissingTelephone;
	
	public String register_MissingTelephoneText() {
		String text = register_MissingTelephone.getText();
		return text;
	}
	
	
	@FindBy( xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement register_MissingPassword;
	
	public String register_MissingPasswordText() {
		String text = register_MissingPassword.getText();
		return text;
	}
	
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement register_MissingPolicy;
	
	
	public String register_MissingPolicyText() {
		String text = register_MissingPolicy.getText();
		return text;
	}
	
	@FindBy( css = ".alert.alert-danger.alert-dismissible")
	private WebElement register_AlreadyRegisteredEmail;
	
	public String register_AlreadyRegisteredEmailGetText() {
		String msg = register_AlreadyRegisteredEmail.getText();
		return msg;
	}
	
}




































































