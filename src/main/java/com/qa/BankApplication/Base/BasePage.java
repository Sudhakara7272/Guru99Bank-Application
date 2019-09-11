package com.qa.BankApplication.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Sudhakara Reddy
 *
 */
public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to initialize the driver on the basis of given browser
	 * @return
	 */
	public WebDriver initialize_driver(Properties prop) {
		//String browser= "chrome";
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	/**
	 * this method is used to define the properties
	 * @return this method returns properties prop references
	 */
	public Properties initialize_properties() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\qa\\BankApplication\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public void quitBrowser() {
		try {
		driver.quit();
		} catch(Exception e) {
			System.out.println("some Exception occured while quetting browser");
		}
	}
	public void closeBrowser() {
		try {
		driver.close();
		} catch(Exception e) {
			System.out.println("some Exception occured while closing browser");
		}
	}
}
