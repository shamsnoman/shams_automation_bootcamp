package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.CheckOutPage;
import com.tutorialsninja.qa.pages.CheckOutRegistration;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.ShoppingCartPage;
import com.tutorialsninja.testBase.TestBase;

public class AddProductToCartTest extends TestBase {
	
	public WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();
	
	public AddProductToCartTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test
	
	public void Checkout() {
		
		HomePage homePage = new HomePage(driver);
		homePage.home_MacAddtoCartClick();
		homePage.home_ShoppingCartClick();
		
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		shoppingCart.shoppingCart_checkOutLinkClick();	
		
		CheckOutPage checkOut = new CheckOutPage(driver);
		checkOut.checkOut_GuestRadioButtonClick();
		checkOut.checkOut_CheckOutContinuebuttonClick();
		

		
		CheckOutRegistration checkReg = new CheckOutRegistration(driver);
		checkReg.checkReg_FirstNameEdit(dataProp.getProperty("firstame"));
		checkReg.checkReg_LastNameEdit(dataProp.getProperty("lastame"));
     	checkReg.checkReg_EmailEdit(dataProp.getProperty("email"));
		checkReg.checkReg_TelephoneEdit(dataProp.getProperty("telephone"));
		checkReg.checkReg_Address1Edit(dataProp.getProperty("address1"));
		checkReg.checkReg_CityEdit(dataProp.getProperty("city"));
		checkReg.checkReg_PostCode(dataProp.getProperty("postCode"));
		//checkReg.checkReg_RegisterContinueBtnClick();
		checkReg.checkReg_CountrySelect();
		checkReg.checkReg_ZoneSelect();	
		
		
		WebElement registerContinueBtn = driver.findElement(By.xpath("//input[@id='button-guest']"));
		registerContinueBtn.click();
		

		checkOut.checkOut_TermsCheckBoxClick();
		checkOut.checkOutPaymentContinuebtnClick();
			
		
		String actualPaymentWarning = checkOut.checkOut_WarningElementGetText();
		String expectedPaymentWarning = "Warning: Payment method required!";
		softAssert.assertEquals(actualPaymentWarning, expectedPaymentWarning);
		
		
	}
	

}













