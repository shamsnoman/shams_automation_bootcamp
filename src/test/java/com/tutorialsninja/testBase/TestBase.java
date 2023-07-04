package com.tutorialsninja.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utilities.Utilities;

public class TestBase {

	public WebDriver driver;
	public ChromeOptions chromeOptions;
	
	
	public FileInputStream input;
	public FileInputStream input1;
	
	public File file;
	public File file1;
	
	
	public Properties prop;
	public Properties dataProp;

	public TestBase() throws IOException {
		file = new File(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		input = new FileInputStream(file);
		prop = new Properties();
		prop.load(input);
		
		
		file1 = new File(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\testdata\\dataprop.properties");
				
		input1 = new FileInputStream(file1)	;	
		dataProp = new Properties();
		dataProp.load(input1);

	

	}

	public WebDriver initializeBrowser(String browser) {
  
		if (browser.equalsIgnoreCase("Chrome")) {
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver(chromeOptions);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGELOAD_TIMEOUT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.SCRIPT_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		return driver;

	}
	
	
	
	

	

	
	

}
