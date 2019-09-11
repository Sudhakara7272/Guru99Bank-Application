package com.qa.BankApplication.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BankApplication.Base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;	
	}
	
	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		WebElement element=null;
		try {
		 element=driver.findElement(locator);
		} catch(Exception e) {
			System.out.println("some exception occured while creating WebElement"+locator);
		}
		return element;
	}
	
	public void waitForElementPresent(By locator) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void doCLick(By locator) {
		try {
		getElement(locator).click();
		} catch(Exception e) {
			System.out.println("some exception occured while clicking on WebElement"+locator);
		}
	}
	
	public void doSendKeys(By locator, String value) {
		try {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		} catch(Exception e) {
			System.out.println("some exception occured while sending on WebElement"+locator);
		}
	}
	
	public String doGetText(By locator) {
		String text=null;
		try {
		text= getElement(locator).getText();
		} catch(Exception e) {
			System.out.println("some exception occured while getting text"+locator);
		}
		return text;
	}
	
	public String waitForPageTitle(String title) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	public boolean isElementDisplayed(By locator) {
		try {
		return getElement(locator).isDisplayed();
		} catch(Exception e) {
			System.out.println("some exception occured checking webElement getting text"+locator);
			return false;
		}
	}
	
}
