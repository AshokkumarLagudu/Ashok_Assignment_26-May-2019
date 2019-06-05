package com.ashok.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ashok.base.Base;
import com.ashok.util.ReusableMethods;

public class Peoples extends Base{
	
	@FindBy(xpath="//a[@href='/party/person/new']")
	private WebElement addPerson;
	
	@FindBy(xpath="//select[@name='party:j_id108:j_id116']")
	private WebElement selectTitle;
	
	@FindBy(xpath="//div[@id='party:fnDecorate']//span/input")
	private WebElement firstName;
	
	@FindBy(xpath="//div[@id='party:lnDecorate']//span/input")
	private WebElement lastName;
	
	@FindBy(xpath="//div[@id='party:roleDecorate']//span/input")
	private WebElement jobTitle;
	
	@FindBy(xpath="//div[@id='party:orgDecorate']//span/input")
	private WebElement organisation;
	
	@FindBy(xpath="//div[@class='addTagComboBox']/span/input")
	private WebElement tag;
	
	@FindBy(xpath="//input[@class='btn-secondary btn-small addTagButton']")
	private WebElement addTag;
	
	@FindBy(xpath="//div[@id='party:j_id325:0:phnDecorate']//span/input")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//div[@id='party:j_id325:0:phnDecorate']//span/div/select")
	private WebElement typeOfNumber;
	
	@FindBy(xpath="//div[@id='party:j_id342:0:emlDecorate']//span/div/select")
	private WebElement typeOfEmail;
	
	@FindBy(xpath="//div[@id='party:j_id342:0:emlDecorate']//span/input")
	private WebElement email;
	
	@FindBy(xpath="//div[@class='inlinesection'][4]/span/a")
	private WebElement addAddress;
	
	@FindBy(xpath="//span[@id='party:addrPanel']//div[@class='prop']/span[1]/textarea")
	private WebElement addressTextarea;
	
	@FindBy(xpath="//select[@name='party:j_id389:0:j_id438']")
	private WebElement addressType;
	
	@FindBy(xpath="//span[@id='party:addrPanel']//div[@class='prop']/span/input[@id='party:j_id389:0:ctyDecorate:cty']")
	private WebElement city;
	
	@FindBy(xpath="//span[@id='party:addrPanel']//div[@class='prop']/span/input[@id='party:j_id389:0:rgnDecorate:dist']")
	private WebElement state;
	
	@FindBy(xpath="//span[@id='party:addrPanel']//div[@class='prop']/span/input[@id='party:j_id389:0:ctyPstCd:pstCd']")
	private WebElement zipcode;
	
	@FindBy(xpath="//select[@name='party:j_id389:0:cntryDecorate:j_id431']")
    private WebElement country;	
	
	@FindBy(xpath="//div[@class='form-footer-line']//li[1]//input[@type='submit']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='party-details-text']/span[@class='party-details-title']")
	private WebElement addedNewPersonName;
	
	//Initializing WebElements
	public Peoples(){
		PageFactory.initElements(driver, this);
	}
	
	//click on add person button
	public void click_On_add_Person(){
		
		waitUntilElementVisible(addPerson);
		addPerson.click();

	}
	
	public String get_Added_New_PersonName(){
		waitUntilElementVisible( addedNewPersonName);
		return addedNewPersonName.getText().trim();
	}
	//select title
	public void select_Title(String text){
		
		ReusableMethods.selectByText(selectTitle, text);
	}
	
	
	//entering first name
	public void enter_First_Name(String fName){
		firstName.clear();
		firstName.sendKeys(fName);
	}
	
	//entering last name
	public void enter_Last_Name(String lName){
		lastName.clear();
		lastName.sendKeys(lName);
	}
	
	//enter job title
	public void enter_job_Title(String jobtitle){
		jobTitle.clear();
		jobTitle.sendKeys(jobtitle);
	}
	
	//enter organization name
	public void enter_Organisation(String orgName){
		organisation.clear();
		organisation.sendKeys(orgName);
	}
	
	//enter tag name
	public void enter_Tag(String tagName){
		tag.clear();
		tag.sendKeys(tagName);
		addTag.click();
	}
	
	//enter phone number and type of phone number
	public void eneter_Phone_Number(String phNumber){
		
		phoneNumber.clear();
		phoneNumber.sendKeys(phNumber);
		
	}
	
	//enter phone number and type of phone number type
		public void eneter_Phone_Number_Type(String phType){
			
			ReusableMethods.selectByText(typeOfNumber, phType);
		}
	
	//enter email id and type of email
	public void enter_Email(String emailAdd){
		email.clear();
		email.sendKeys(emailAdd);
		
	}
	
	//enter email id and type of email type
	public void enter_Email_Type(String emailType){
		
		ReusableMethods.selectByText(typeOfEmail, emailType);
	}
	//click on add address button
	public void click_On_add_Address(){
		ReusableMethods.scrollPageDown(driver);
		waitUntilElementVisible(addAddress);
		addAddress.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//enter address in address text box
	public void enter_Address(String address){
		//waitUntilElementVisible(addressTextarea);
		addressTextarea.sendKeys(address);
		
	}
	
	public void enter_Address_Type(String addType){
		
		ReusableMethods.selectByText(addressType, addType);
	}
	
	//enter city name
	public void enter_City(String cityName){
		city.clear();
		city.sendKeys(cityName);
	}
	
	//enter postal Zipcode
	public void enter_Zipcode(String zip){
		zipcode.clear();
		zipcode.sendKeys(zip);
	}
	
	//enter state name
	public void enter_State(String stateName){
		state.clear();
		state.sendKeys(stateName);
	}
	//select country name
	public void selectCountry(String countryName){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReusableMethods.selectByText(country, countryName);
		
	}
	
	//click on save button
	public void click_On_Save(){
		save.click();
	}
	
	//fill new person details in form
	public void fill_User_Details(String key,String value){
		
		switch(key){
		case "Title":select_Title(value);
		break;
		             
		case "FirstName":enter_First_Name(value);
		break;
		
		case "LastName" :enter_Last_Name(value);
		break;
		                
		case "JobTitle" :enter_job_Title(value);
		break;
		
		case "Organisation" :enter_Organisation(value);
        break;
        
		case "Tags" :enter_Tag(value);
        break;
		
		case "PhoneNumber" :eneter_Phone_Number(value);
        break;
		
		case "Email" :enter_Email(value);
        break;
		
		case "Address" :click_On_add_Address();
			waitUntilElementVisible(addressTextarea);
			try {
				enter_Address(value);
			} catch (Exception e) {
				enter_Address(value);
			}
        break;
		
		case "City" :enter_City(value);
        break;
		
		case "State" :enter_State(value);
        break;
		
		case "Country" :selectCountry(value);
        break;
		
		case "EmailType" :enter_Email_Type(value);
        break;
		
		case "PhoneType" :
			
			eneter_Phone_Number_Type(value);
        break;
		
		case "AddressType" :
			
			enter_Address_Type(value);
        break;
		
		case "ZipCode" :
			waitUntilElementVisible(zipcode);
			zipcode.clear();
			enter_Zipcode(value);
        break;
        
        default :
        	break;
        
		}
		
	}

}
