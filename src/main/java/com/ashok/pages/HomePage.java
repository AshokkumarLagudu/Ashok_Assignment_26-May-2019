package com.ashok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.ashok.base.Base;

import com.ashok.util.Utils;

public class HomePage extends Base {
	WebDriverWait wait=new WebDriverWait(driver,Utils.wedriverWait);
	
	@FindBy(xpath="//div[@class='nav-bar-section nav-bar-main is-teams-launch']//nav[@role='navigation']//span/a[@aria-label='People & Organisations']")
	private WebElement peopleOrganisation;
	
	@FindBy(xpath="//div[@class='nav-bar-section nav-bar-main is-teams-launch']//nav[@role='navigation']//span/a[@aria-label='Cases']")
	private WebElement cases;
	
	@FindBy(xpath="//nav[@role='navigation']/a[@original-title='Cases']")
	private WebElement cases2;
	
	@FindBy(xpath="//div[@class='nav-bar-account-details']/span[@class='nav-bar-account-name']")
	private WebElement accountName;
	
	@FindBy(linkText="Account Settings")
	private WebElement accountSettings;
	
	public HomePage(){
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPeople(){
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='nav-bar-section nav-bar-main is-teams-launch']//nav[@role='navigation']//span[2]/a")))).click();
		
				peopleOrganisation.click();
		
	}
	
	public Cases clickOnCases(){
		
		try {
			cases.click();
		} catch (Exception e) {
			cases2.click();
		}
		return new Cases();
       
	}
	
	public WebElement click_On_AccountName(){
		
		
		return accountName;
		
	}
	
	public void click_On_accoutnSettings(){
		waitUntilElementVisible(accountSettings);
		accountSettings.click();
	}

}
