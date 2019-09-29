package com.qa.BankApplication.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BankApplication.Base.BasePage;

public class ElementUtil extends BasePage{
	
	public WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By locator) {
		waitforElementPresent(locator);
		WebElement element=null;
		try {
		element=driver.findElement(locator);
		if(flash.equalsIgnoreCase("yes")) {
		JavaScriptUtil.flash(element, driver);
		}
		} catch (Exception e) {
			System.out.println("some exception occured while getting the WebElement"+locator);
		}
		return element;
	}
	
	public void waitforElementPresent(By locator) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void doClick(By locator) {
		try {
		getElement(locator).click();
		} catch(Exception e) {
			System.out.println("some Exception occured while clicking on WebElement"+locator);
		}
	}
	public void doSendKeys(By locator, String value) {
		try {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		} catch(Exception e) {
		System.out.println("some exception occures while sending values"+locator);
		}
	}
	public String doGetText(By locator) {
		String text=null;
		try {
		text=getElement(locator).getText();
		} catch(Exception e) {
			System.out.println("some exception occured while getting text"+locator);
		}
		return text;
	}
	
	public String waitforPageTitle(String title) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(By locator) {
		try {
		return getElement(locator).isDisplayed();
		} catch(Exception e) {
			System.out.println("some exception occured while checking webElement displayed"+locator);
			return false;
		}
	}
	
	public void selectByvisibleText(By locator, String value) {
		WebElement element=getElement(locator);
		Select select=new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	

}
