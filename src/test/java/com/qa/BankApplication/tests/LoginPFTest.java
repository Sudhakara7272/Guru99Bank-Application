package com.qa.BankApplication.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BankApplication.Base.BasePage;
import com.qa.BankApplication.Pages.LoginPage;
import com.qa.BankApplication.Pages.LoginPagePF;
import com.qa.BankApplication.util.Constants;

public class LoginPFTest {
	
	WebDriver driver;
	BasePage basePage;
	LoginPagePF loginPagePF;
	Properties prop;
	
	@BeforeMethod
	public void setUp() {
		basePage= new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPagePF=new LoginPagePF(driver);
	}
	@Test(priority=1, description="login test with correct username and correct password....")
	public void loginTest() {
		loginPagePF.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}

	


