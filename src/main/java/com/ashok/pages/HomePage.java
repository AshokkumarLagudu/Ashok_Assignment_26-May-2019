package com.ashok.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ashok.base.Base;

public class HomePage extends Base {
	
	@FindBy(xpath="//div[@class='nav-bar-section nav-bar-main is-teams-launch']//nav[@role='navigation']//span[2]/a")
	private WebElement people_organisation;
	
	@FindBy(xpath="//div[@class='nav-bar-section nav-bar-main is-teams-launch']//nav[@role='navigation']//span[5]/a")
	private WebElement cases;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPeople(){
		
		waitUntilElementclickable(people_organisation);
	}
	
	public void clickOnCases(){
		
		waitUntilElementclickable(cases);
	}

}
