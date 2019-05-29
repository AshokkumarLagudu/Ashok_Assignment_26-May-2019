package com.ashok.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ashok.base.Base;

public class LoginPage extends Base {
	
	@FindBy(xpath="//div[@class='clearfix']/div[@id='login:usernameDecorate']//div[@class='prop']//span/input")
	private WebElement username;
	
	@FindBy(xpath="//div[@class='clearfix']/div[@id='login:passwordDecorate']//div[@class='prop']//span/input")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUsername(String userName){
		username.sendKeys(userName);
	}
	
	public void enterPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin(){
		waitUntilElementclickable(login);
		
		
	}

}
