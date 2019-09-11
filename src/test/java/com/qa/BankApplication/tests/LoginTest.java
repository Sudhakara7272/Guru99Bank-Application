package com.qa.BankApplication.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BankApplication.Base.BasePage;
import com.qa.BankApplication.Pages.LoginPage;
import com.qa.BankApplication.util.Constants;
import com.qa.BankApplication.util.ElementUtil;

public class LoginTest {
	
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	
	@BeforeMethod
	public void setUp() {
		basePage= new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
	}
	@Test(priority=1, description="login test with correct username and correct password....")
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=2, description="login page title test....")
	public void loginPageTitleTest() {
		String title=loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Page is incorrect..");
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
