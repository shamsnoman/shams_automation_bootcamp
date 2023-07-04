package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, HomePage.class);
	}

	@FindBy(linkText = "My Account")
	private WebElement home_MyAccountLink;

	public void home_MyAccountClick() {
		home_MyAccountLink.click();
	}

	@FindBy(linkText = "Login")
	private WebElement home_LoginLink;

	public void home_LoginClick() {
		home_LoginLink.click();
	}

	@FindBy(linkText = "Register")
	private WebElement home_RegisterLink;

	public void home_RegisterClick() {
		home_RegisterLink.click();
	}

	@FindBy(xpath = "//input[@name ='search']")
	private WebElement home_Searchbox;

	public void home_SearchboxEdit(String searchItem) {
		home_Searchbox.sendKeys(searchItem);
	}

	@FindBy(css = ".btn.btn-default.btn-lg")
	private WebElement home_SearchIcon;

	public void home_SearchIconClick() {
		home_SearchIcon.click();
	}

	@FindBy(linkText = "Contact Us")
	private WebElement home_ContactLink;

	public void home_ContactLinkClick() {
		home_ContactLink.click();
	}

	@FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
	private WebElement home_MacAddtoCart;

	public void home_MacAddtoCartClick() {
		home_MacAddtoCart.click();
	}

	@FindBy(xpath = "//span[text()='Shopping Cart']")

	private WebElement home_ShoppingCart;

	public void home_ShoppingCartClick() {
		home_ShoppingCart.click();
	}
	
	@FindBy( xpath = "//span[@id='cart-total']")
	private WebElement home_Cart;
	
	public void home_CartClick() {
		home_Cart.click();
	}
	
	@FindBy( xpath = "//p[@class='text-center']")
	private WebElement home_CartTextBox;
	
	public String home_CartTextBoxGetText() {
		String msg = home_CartTextBox.getText();
		return msg;
	}
	
	
	
}












