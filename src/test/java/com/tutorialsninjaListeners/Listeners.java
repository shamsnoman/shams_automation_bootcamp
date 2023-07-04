package com.tutorialsninjaListeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tutorialsninja.extentReports.ExtentReporter;
import com.tutorialsninja.testBase.ScreenShot;

import io.cucumber.core.backend.Status;

public class Listeners implements ITestListener {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
		threadLocal.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.pass("the test is passed");
		test.log(com.aventstack.extentreports.Status.INFO, result.getName()+"-----passed--------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.info("the test is failed");
		// test.fail(result.getThrowable());
		threadLocal.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String filepath = ScreenShot.getScreenShot(result.getMethod().getMethodName(), driver);
		// test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		threadLocal.get().addScreenCaptureFromBase64String(filepath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	} 

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html";
		File extentReportpath = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReportpath.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
