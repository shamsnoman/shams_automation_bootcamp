package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.ContactUsPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.testBase.TestBase;

public class CustomerServiceTest extends TestBase{

	public CustomerServiceTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void contactforService() {
;
		HomePage homePage = new HomePage(driver);
		homePage.home_ContactLinkClick();		

		ContactUsPage contact = new ContactUsPage(driver);
		contact.contact_NameEdit(dataProp.getProperty("name"));
		contact.contact_EmailEdit(dataProp.getProperty("contactEmail"));
		contact.contact_QueryEdit(dataProp.getProperty("query"));
		contact.contact_SubmitBtnClick();
		contact.contact_ContinueLinkClick();
			
		String actualpageTitle = driver.getTitle();
		String expectedpageTitle = "Your Store";
		softAssert.assertEquals(actualpageTitle, expectedpageTitle);
		
	}
	
	
}










