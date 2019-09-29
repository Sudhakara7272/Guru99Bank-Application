package com.qa.BankApplication.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.BankApplication.Base.BasePage;

public class ElementUtilPF extends BasePage{
	
	WebDriver driver;
	public ElementUtilPF(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getElement( By locator) {
		driver.findElement(locator);
	}

}
