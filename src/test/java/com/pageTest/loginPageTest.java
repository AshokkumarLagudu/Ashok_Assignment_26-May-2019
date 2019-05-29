package com.pageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ashok.base.Base;
import com.ashok.pages.LoginPage;

public class loginPageTest extends Base {
	LoginPage loginpage;

	loginPageTest() {
		super();
	}

	// Application Initialization
	@BeforeClass
	public void openBrowser() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void loginToAccount(){
		
		
		loginpage.enterUsername(prop.getProperty("userName"));
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickOnLogin();
	}
	
	@Test
	public void addNewPerson(){
		
	}
	
}
