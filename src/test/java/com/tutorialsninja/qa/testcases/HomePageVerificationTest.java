package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.testBase.TestBase;

public class HomePageVerificationTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();

	public HomePageVerificationTest() throws IOException {
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
	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		
		
		
		String expectedpageTitle = driver.getTitle();
		
		String actualPageTitle = dataProp.getProperty("actualPageTitle");
		
		softAssert.assertEquals(actualPageTitle, expectedpageTitle);
		System.out.println(expectedpageTitle);
		
	}
	
	@Test(priority = 2)
	public void verifyHomePageCart() {
		
		HomePage homePage = new HomePage(driver);
		homePage.home_CartClick();

		String actualCartText = homePage.home_CartTextBoxGetText();
	
		String expectedCartText = dataProp.getProperty("expectedCartText");
		softAssert.assertEquals(actualCartText, expectedCartText);
		softAssert.assertAll();
		
		
	}
	
	@Test(priority = 3)
	public void verifyClickOnAhomePageLink() {
		WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
		aboutUsLink.click();
		
		String actualPageTitle = driver.getTitle();
		
		String expectedPageTitle = dataProp.getProperty("expectedPageTitle");
		
		softAssert.assertEquals(actualPageTitle, expectedPageTitle);
		
		
		
		
		
	}
	
	

}




















