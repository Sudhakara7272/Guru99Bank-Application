package com.qa.BankApplications.listeners;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

public class ExtentReportListeners {
	
	ExtentReports report; // will help you to generate your report
	ExtentTest logger; // loggin report.. Failed abd passed test cases
	
	
	
	@BeforeTest
	public void launch() {
		//generate extent report
		
	}
	@Test
	public void passedTestCase() {
		
	}
}
