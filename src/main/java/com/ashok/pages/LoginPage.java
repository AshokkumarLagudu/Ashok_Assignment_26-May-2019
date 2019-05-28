package com.ashok.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath="//span[@class='input ']/input[@id='login:usernameDecorate:username']")
	private WebElement username;
	
	@FindBy(xpath="//span[@class='input ']/input[@id='login:passwordDecorate:password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	
	public void enterUsername(String userName){
		username.sendKeys(userName);
	}
	
	public void enterPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin(){
		login.click();
	}

}
