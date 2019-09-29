package com.qa.BankApplication.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.BankApplication.Base.BasePage;
import com.qa.BankApplication.Pages.HomePage;
import com.qa.BankApplication.Pages.LoginPage;
import com.qa.BankApplication.Pages.NewCustomerPage;
import com.qa.BankApplication.util.Constants;
import com.qa.BankApplication.util.ExcelUtil;

public class NewCustomerTest {

	
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	NewCustomerPage newcutomerpage;
	
	@BeforeMethod
	public void setUp() {
		basePage= new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		newcutomerpage=homePage.clickonNewCustomer();
		
	}
	
	@DataProvider()
	public Object[][] getCustomerData() {
		Object data[][]=ExcelUtil.getTestData("CreateCustomer");
		return data;
	}
	
	
	@Test(dataProvider="getCustomerData")
	public void NewCustomerPageTest(String name, String DOB, String Address, String City, String State, String PIN, String Mobile, String Email, String Password) {
		newcutomerpage.NewCutomer(name, DOB, Address, City, State, PIN, Mobile, Email, Password);	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}




