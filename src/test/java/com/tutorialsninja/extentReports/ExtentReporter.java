package com.tutorialsninja.extentReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports generateExtentReport()  {
		
		File file = new File(System.getProperty("user.dir")+
				"\\test-output\\ExtentReports\\extentreport.html");
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("TutorialsNinja Test report");
		reporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Engineer", "Shams");

		
		
		
		
		File propertiesFile = new File(System.getProperty("user.dir")+
				"\\src\\test\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream input = null;
		try {
			input = new FileInputStream(propertiesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		
		extent.setSystemInfo("username", prop.getProperty("validUsername"));
		extent.setSystemInfo("password", prop.getProperty("validPassword"));
		
		return extent;
	}
}
