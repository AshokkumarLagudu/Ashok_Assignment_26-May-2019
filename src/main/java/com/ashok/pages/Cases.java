package com.ashok.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ashok.base.Base;
import com.ashok.util.ReusableMethods;

public class Cases extends Base {
	
	@FindBy(xpath="//a[@href='/case/add']")
	private WebElement addCaseButton;
	
	@FindBy(xpath="//span[@class='field']//input[@id='partySearch']")
	private WebElement caseRelatesTo;
	
	@FindBy(xpath="//div[@id='caseNameDecorate']//input[@name='caseNameDecorate:name']")
	private WebElement name;
	
	@FindBy(xpath="//div[@id='caseDescriptionDecorate']//span/textarea")
	private WebElement description;
	
	@FindBy(xpath="//input[@name='tagsDecorate:tagComboBox']")
	private WebElement tags;
	
	@FindBy(xpath="//input[@name='save']")
	private WebElement save;
	
	@FindBy(xpath="//div[contains(text(),'Case status is ')]/span")
	private WebElement caseStatus;
	
	@FindBy(xpath="//span[@id='editFormPanel']/span")
	private WebElement newCase;
	
	@FindBy(xpath="//div[@class='entity-details ember-view']/div[@class='entity-details-title']")
	private WebElement newCaseName;
	
	public Cases(){
		PageFactory.initElements(driver, this);
	}
	
	public String get_newCase_Name(){
		waitUntilElementVisible(newCaseName);
		return newCaseName.getText();
	}
	public String get_newCase_text(){
		String newcase=newCase.getText();
		return newcase;
	}
	public void click_On_AddCase(){
		waitUntilElementVisible(addCaseButton);
		addCaseButton.click();
	}
	
	public void enter_text_caseRelatesTo(String data){
		waitUntilElementVisible(caseRelatesTo);
		caseRelatesTo.sendKeys(data);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		caseRelatesTo.sendKeys(Keys.DOWN, Keys.RETURN);
		
		
	}
	
	public void enter_Name(String nm){
		waitUntilElementVisible(name);
		name.sendKeys(nm);;
	}
	
	public void enter_Description(String descrp){
		waitUntilElementVisible(description);
		description.sendKeys(descrp);
	}
	
	public void enter_Tags(String tag){
		waitUntilElementVisible(tags);
		tags.sendKeys(tag);
	}
	
	public String get_Case_Status(){
		waitUntilElementVisible(caseStatus);
		String status =caseStatus.getText();
		return status;
	}
	public void click_On_Save(){
		waitUntilElementclickable(save);
	}
	
	
	public void fill_New_Case_Form(String key,String value){
		
		switch(key){
		
		case "Case Relates To*":
		    caseRelatesTo.clear();
			enter_text_caseRelatesTo(value);
			break;
		
		case "Name*":
			name.clear();
			enter_Name(value);
			break;
		case "Description":
			description.clear();
			enter_Description(value);
			break;
		case "Tags":
			tags.clear();
			enter_Tags(value);
			break;
		
		default: System.out.println("There is no matched key --> "+key);
		
		}
		
	}

}
