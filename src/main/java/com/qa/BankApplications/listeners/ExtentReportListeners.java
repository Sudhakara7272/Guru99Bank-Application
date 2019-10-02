package com.qa.BankApplications.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

public class ExtentReportListeners implements ITestListener {

	public void onFinish(ITestContext arg0) {
		
	}

	public void onStart(ITestContext arg0) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	public void onTestFailure(ITestResult Result) {
		System.out.println("Testcases failedand details are "+Result.getName());
		
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("Testcases skipped and details are "+Result.getName());
		
	}

	public void onTestStart(ITestResult Result) {
		System.out.println("Testcases teststart and details are "+Result.getName());
		
	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("Testcases success and details are "+Result.getName());
		
	}
	
	
}
