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

import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.testBase.TestBase;

public class SearchProductTest extends TestBase {
	
	public WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();
	
	
	public SearchProductTest() throws IOException {
		super();		
	}
	
	
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browser"));//calling the parent class method	and parent class variable
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchWithValidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.home_SearchboxEdit(dataProp.getProperty("validProduct"));
		homePage.home_SearchIconClick();
		
		SearchPage search = new SearchPage(driver);
		
		String actualProductConfirmationText = search.search_ProductConfirmationText();  
		String expectedProductConfirmationText = dataProp.getProperty("expectedProductConfirmationText");
		softAssert.assertEquals(actualProductConfirmationText, expectedProductConfirmationText);
		
	}

	
	@Test(priority=2)
	public void searchWithInvalidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.home_SearchboxEdit(dataProp.getProperty("invalidProduct"));
		homePage.home_SearchIconClick();
		
		SearchPage search = new SearchPage(driver);	
		
		String actualInvalidProductText =   search.search_InvalidProductGetText();
		String expectedInvalidProductText = dataProp.getProperty("expectedInvalidProductText");
		softAssert.assertTrue(actualInvalidProductText.contains(expectedInvalidProductText));
	}
	
	
	@Test(priority=3)
	public void searchWithNoProduct() {
		
		HomePage homePage = new HomePage(driver);		
		homePage.home_SearchIconClick();
		
        SearchPage search = new SearchPage(driver);	
		
		String actualNoProductText =   search.search_InvalidProductGetText();
		String expectedNoProductText = dataProp.getProperty("expectedNoProductText");
		softAssert.assertTrue(actualNoProductText.contains(expectedNoProductText));
	}
	
	
}
