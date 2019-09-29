package com.qa.BankApplication.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BankApplication.Base.BasePage;
import com.qa.BankApplication.util.ElementUtil;
import com.qa.BankApplication.util.ElementUtilPF;

public class LoginPagePF extends BasePage{
	
	WebDriver driver;
	ElementUtilPF elementutilpf;
	
	//Page Factory pattern with the help of @FindBy
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginbutton;
	
	public LoginPagePF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutilpf=new ElementUtilPF(driver);
	}
	
	public void doLogin(String Username, String PWD) {
		username.sendKeys(Username);
		password.sendKeys(PWD);
		loginbutton.click();
		
	}

}
