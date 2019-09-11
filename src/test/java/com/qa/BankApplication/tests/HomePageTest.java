package com.qa.BankApplication.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BankApplication.Base.BasePage;
import com.qa.BankApplication.Pages.HomePage;
import com.qa.BankApplication.Pages.LoginPage;
import com.qa.BankApplication.util.Constants;

public class HomePageTest {

	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage= new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test (priority=1)
	public void verifyHomePageTitleTest() {
		String title=homePage.getHomepageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	@Test (priority=2)
	public void verifyHomePageHeaderTest() {
		String headervalue=homePage.getHomePageHeadervalue();
		System.out.println("home page header is::"+headervalue);
		Assert.assertEquals(headervalue, Constants.HOME_PAGE_HEADER);
	}
	@Test (priority=3)
	public void verifyLoggedUserAccoutName() {
		String accountname=homePage.getLoggedInAccountName();
		System.out.println("logged in account is ::"+accountname);
		Assert.assertEquals(accountname, prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


