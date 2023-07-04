package com.tutorialsninja.qa.testcases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utilities.Utilities;
import com.tutorialsninja.testBase.TestBase;

public class RegisterTest extends TestBase{
	
	
	public RegisterTest() throws IOException {
		super();		
	}



	public WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browser"));//calling the parent class method	and parent class variable	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority = 1)
	public void registerAccountWithMandatoryFields() {

		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_RegisterClick();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.register_firstName(dataProp.getProperty("firstName"));
		registerPage.register_lastName(dataProp.getProperty("lastName"));
		registerPage.register_EmailId(Utilities.emailWithDateTimeStamp());
		registerPage.register_TelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.register_passwordId(prop.getProperty("validPassword"));
		registerPage.register_ConfirmPasswordId(prop.getProperty("validPassword"));
		registerPage.register_SubscribeYesButtonClick();
		registerPage.register_PolicyCheckboxClick();
		registerPage.register_ContinueButtonClick();
		
		
	    AccountSuccessPage success = new AccountSuccessPage(driver);		
		
		String actualAccountConfirmationText = success.accountSuccess_AccountConfirmationText() ;
		String expectedAccountConfirmationText = dataProp.getProperty("expectedAccountConfirmationText");
		
		softAssert.assertTrue(actualAccountConfirmationText.contains(expectedAccountConfirmationText));
		softAssert.assertAll();
	}
	
	
	@Test(priority = 2)
	public void registerAccountWithExistingEmail() {
		

		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_RegisterClick();		
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.register_firstName(dataProp.getProperty("firstName"));
		registerPage.register_lastName(dataProp.getProperty("lastName"));
		registerPage.register_EmailId(prop.getProperty("validEmail"));
		registerPage.register_TelephoneNumber(dataProp.getProperty("telephone"));		
		registerPage.register_passwordId(prop.getProperty("validPassword"));
		registerPage.register_ConfirmPasswordId(prop.getProperty("validPassword"));
		registerPage.register_SubscribeYesButtonClick();
		registerPage.register_PolicyCheckboxClick();
		registerPage.register_ContinueButtonClick();	
		
		String actualAlreadyRegisteredEmailText =  registerPage.register_AlreadyRegisteredEmailGetText();
		String expectedAlreadyRegisteredEmailText = dataProp.getProperty("expectedAlreadyRegisteredEmailText");
		softAssert.assertTrue(actualAlreadyRegisteredEmailText.contains(expectedAlreadyRegisteredEmailText));
		softAssert.assertAll();
		
		
		
	}
	
	
	@Test(priority = 3)
	public void registerAccountWithAllFields() {
		
		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_RegisterClick();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.register_firstName(dataProp.getProperty("firstName"));
		registerPage.register_lastName(dataProp.getProperty("lastName"));
		registerPage.register_EmailId(Utilities.emailWithDateTimeStamp());
		registerPage.register_TelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.register_passwordId(prop.getProperty("validPassword"));
		registerPage.register_ConfirmPasswordId(prop.getProperty("validPassword"));
		registerPage.register_SubscribeYesButtonClick();
		registerPage.register_PolicyCheckboxClick();
		registerPage.register_ContinueButtonClick();
		

		AccountSuccessPage success = new AccountSuccessPage(driver);
		
		
		String actualAccountConfirmationText = success.accountSuccess_AccountConfirmationText() ;
		String expectedAccountConfirmationText = dataProp.getProperty("expectedAccountConfirmationText");
		
		softAssert.assertTrue(actualAccountConfirmationText.contains(expectedAccountConfirmationText));
		softAssert.assertAll();
		
	}
	
	
	
	@Test(priority = 4)
	public void registerAccountWithNoFields() {
		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_RegisterClick();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.register_ContinueButtonClick();		

		String actualMissingFirstNameText = registerPage.register_MissingFirstNameText();
		String expectedMissingFirstNameText = dataProp.getProperty("expectedMissingFirstNameText");
		softAssert.assertEquals(actualMissingFirstNameText, expectedMissingFirstNameText);		
		
		String actualMissingLasttNameText = registerPage.register_MissingLastNameText();
		String expectedMissingLastNameText = dataProp.getProperty("expectedMissingLastNameText");
		softAssert.assertEquals(actualMissingLasttNameText, expectedMissingLastNameText);		
		
		String actualMissingEmailText = registerPage.register_MissingEmailText();
		String expectedMissingEmailText = dataProp.getProperty("expectedMissingEmailText");
		softAssert.assertEquals(actualMissingEmailText, expectedMissingEmailText);		
		
		String actualMissingTelephoneText = registerPage.register_MissingTelephoneText();
		String expectedMissingTelephoneText = dataProp.getProperty("expectedMissingTelephoneText");
		softAssert.assertEquals(actualMissingTelephoneText, expectedMissingTelephoneText);
		
		String actualMissingPasswordText =  registerPage.register_MissingPasswordText();
		String expectedMissingPasswordText = dataProp.getProperty("expectedMissingPasswordText");
		softAssert.assertEquals(actualMissingPasswordText, expectedMissingPasswordText);		
		
		String actualMissingPolicyText =  registerPage.register_MissingPolicyText();
		String expectedMissingPolicyText = dataProp.getProperty("expectedMissingPolicyText");
		softAssert.assertTrue(actualMissingPolicyText.contains(expectedMissingPolicyText));		
		softAssert.assertAll();
	}

}
