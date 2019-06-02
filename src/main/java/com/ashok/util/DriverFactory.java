package com.ashok.util;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	private static WebDriver driver;

	// WebDriver setup
	public static WebDriver getDriver(String browserName,String url) {
        
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().version("74").setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")){
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.pageloadTimeout, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Utils.implicitWait, TimeUnit.SECONDS);
		
		driver.get(url);
		
		return driver;
	}

}
