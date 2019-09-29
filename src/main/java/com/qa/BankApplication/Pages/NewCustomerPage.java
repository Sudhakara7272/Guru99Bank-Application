package com.qa.BankApplication.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.BankApplication.Base.BasePage;

public class NewCustomerPage extends BasePage {
	
	WebDriver  driver;
	
	By custname=By.name("name");
	By gender=By.xpath("//input[@value='m']");
	By dob=By.id("dob");
	By address=By.name("addr");
	By city=By.name("city");
	By state=By.name("state");
	By pin=By.name("pinno");
	By mobileno=By.name("telephoneno");
	By email=By.name("emailid");
	By passwordnewcust=By.name("password");
	By submitnewcust=By.name("sub");
	
	public NewCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void NewCutomer(String name, String DOB, String Address, String City, String State, String PIN, String Mobile, String Email, String Password) {
		
		driver.findElement(custname).sendKeys(name);
		driver.findElement(gender).click();
		driver.findElement(dob).sendKeys(DOB);
		driver.findElement(address).sendKeys(Address);
		driver.findElement(city).sendKeys(City);
		driver.findElement(state).sendKeys(State);
		driver.findElement(pin).sendKeys(PIN);
		driver.findElement(mobileno).sendKeys(Mobile);
		driver.findElement(email).sendKeys(Email);
		driver.findElement(passwordnewcust).sendKeys(Password);
		driver.findElement(submitnewcust).click();
		
	}
	

}
