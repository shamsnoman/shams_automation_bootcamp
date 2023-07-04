package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	public WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-name']")
	private WebElement contact_Name;
	
	public void contact_NameEdit(String name) {
		contact_Name.sendKeys(name);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement contact_Email;	
	
	public void contact_EmailEdit(String email) {
		contact_Email.sendKeys(email);
	}
	
	@FindBy(id = "input-enquiry")
	private WebElement contact_Query;
	
	public void contact_QueryEdit(String query) {
		contact_Query.sendKeys(query);
	}
	
	
	@FindBy(css = ".btn.btn-primary")
	
	private WebElement contact_SubmitBtn;
	
	public void contact_SubmitBtnClick() {
		contact_SubmitBtn.click();
	}
	
	@FindBy( linkText = "Continue")
	private WebElement contact_ContinueLink;
	
	public void contact_ContinueLinkClick() {
		contact_ContinueLink.click();
	}
	

}






















