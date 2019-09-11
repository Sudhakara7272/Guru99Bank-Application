package com.qa.BankApplication.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.BankApplication.Base.BasePage;
import com.qa.BankApplication.util.Constants;
import com.qa.BankApplication.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header=By.cssSelector("h2.barone");
	By accountname=By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		 elementUtil=new ElementUtil(driver);
		
	}
	
	public String getHomepageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}
	public String getHomePageHeadervalue() {
		return elementUtil.doGetText(header);
		//return driver.findElement(header).getText();
	}
	public boolean verifyLoggedInAcountName() {
		return elementUtil.isElementDisplayed(accountname);
		//return driver.findElement(accountname).isDisplayed();
	}
	
	public String getLoggedInAccountName() {
		return elementUtil.doGetText(accountname);
		//return driver.findElement(accountname).getText();
	}
	
	}


