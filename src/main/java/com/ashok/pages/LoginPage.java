package com.ashok.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ashok.base.Base;
import com.ashok.util.Utils;

public class LoginPage extends Base {
	//WebDriverWait wait=new WebDriverWait(driver,Utils.wedriverWait);
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
	
	public HomePage clickOnLogin(){
		//wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		login.click();
		//waitUntilElementclickable(login);
		
		return new HomePage();
	}

}
