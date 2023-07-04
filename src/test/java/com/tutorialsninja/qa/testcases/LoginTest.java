 package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.testdata.TN_Exceldata;
import com.tutorialsninja.testBase.TestBase;

public class LoginTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();
	 
	public LoginTest()throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	@Test(priority = 1,dataProvider="TN",dataProviderClass=TN_Exceldata.class,enabled = false)
	public void verifyLogInWithValidCredentials(String email,String password)  {

		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_LoginClick();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login_EmailEdit(email);
		loginPage.login_PasswordEdit(password);
		loginPage.login_Submit();
				
		AccountPage accountPage = new AccountPage(driver);
		String actualAccountInfotext = accountPage.account_GetActualText();
		
		
		String expectedAccountInfotext = dataProp.getProperty("expectedAccountInfotext");
		
		softAssert.assertEquals(actualAccountInfotext, expectedAccountInfotext);
		softAssert.assertAll();
		
	}
	@Test(priority = 2)
	public void verifyLogInWithInvalidCredentials() throws InterruptedException {
		
		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_LoginClick();		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login_EmailEdit(dataProp.getProperty("invalidEmail"));
		loginPage.login_PasswordEdit(dataProp.getProperty("invalidPassword"));
		loginPage.login_Submit();	
		
        String actualNoMatchwarningMessage  = loginPage.login_NoMatchwarningMessage();
        String expectedNoMatchwarningMessage = dataProp.getProperty("expectedNoMatchwarningMessage");
        
		System.out.println(actualNoMatchwarningMessage);
		softAssert.assertEquals(actualNoMatchwarningMessage, expectedNoMatchwarningMessage);
		softAssert.assertAll();
		
	}
	
	@Test(priority = 3)
	public void verifyLogInWithValidEmailInvalidPassword() {
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_LoginClick();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login_EmailEdit(prop.getProperty("validEmail"));
		loginPage.login_PasswordEdit(dataProp.getProperty("invalidPassword"));
		loginPage.login_Submit();		
		
        String actualNoMatchwarningMessage  = loginPage.login_NoMatchwarningMessage();
        String expectedNoMatchwarningMessage = dataProp.getProperty("expectedNoMatchwarningMessage");
        
		System.out.println(actualNoMatchwarningMessage);
		softAssert.assertEquals(actualNoMatchwarningMessage, expectedNoMatchwarningMessage);
		softAssert.assertAll();
		
	}
	
	@Test(priority = 4)
	public void verifyLogInWithInvalidEmailValidPassword() {
		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_LoginClick();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login_EmailEdit(dataProp.getProperty("invalidEmail"));
		loginPage.login_PasswordEdit(prop.getProperty("validPassword"));
		loginPage.login_Submit();		
		
        String actualNoMatchwarningMessage  = loginPage.login_NoMatchwarningMessage(); 
        String expectedNoMatchwarningMessage = dataProp.getProperty("expectedNoMatchwarningMessage");
        
		System.out.println(actualNoMatchwarningMessage);
		softAssert.assertEquals(actualNoMatchwarningMessage, expectedNoMatchwarningMessage);
		softAssert.assertAll();
		
	}
	
	@Test (priority = 5)
	public void verifyLoginWithNoCredentials() {

		
		HomePage homePage = new HomePage(driver);
		homePage.home_MyAccountClick();
		homePage.home_LoginClick();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login_Submit();		
	
        String actualNoMatchwarningMessage  = loginPage.login_NoMatchwarningMessage(); 
        String expectedNoMatchwarningMessage = dataProp.getProperty("expectedNoMatchwarningMessage");
        
		System.out.println(actualNoMatchwarningMessage);
		softAssert.assertEquals(actualNoMatchwarningMessage, expectedNoMatchwarningMessage);
		softAssert.assertAll();
	}


}



















