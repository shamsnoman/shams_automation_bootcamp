package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//h2[text()='Products meeting the search criteria']")
	private WebElement search_ProductConfirmation;
	
	public String search_ProductConfirmationText() {
		String text = search_ProductConfirmation.getText();
		return text;
	}
	
	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
    private WebElement search_InvalidProduct;
	
	public String search_InvalidProductGetText() {
		String msg = search_InvalidProduct.getText();
		return msg;
	}
}
