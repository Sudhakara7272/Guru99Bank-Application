package com.qa.BankApplication.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.BankApplication.Base.BasePage;
import com.qa.BankApplication.util.Constants;
import com.qa.BankApplication.util.ElementUtil;

public class LoginPage extends BasePage{
	//define locators / or with locator (NPF)
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By UserId=By.name("uid");
	By Password=By.name("password");
	By btnLogin=By.name("btnLogin");
	
	// the constructor of Page Class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
	}
	//Page Actions 
	public String getLoginPageTitle() {
		//return elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		//return driver.getTitle();
		return elementUtil.waitforPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	public HomePage doLogin(String username, String pwd) {
		/*driver.findElement(UserId).sendKeys(username);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(btnLogin).click();*/
		elementUtil.doSendKeys(UserId, username);
		elementUtil.doSendKeys(Password, pwd);
		elementUtil.doClick(btnLogin);
		
		
		return new HomePage(driver);
	}
	
	public void selectValueFromDropdown(String value) {
		elementUtil.selectByvisibleText(btnLogin, value);
	}
}
