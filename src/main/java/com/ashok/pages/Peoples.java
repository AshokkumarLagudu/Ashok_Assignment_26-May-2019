package com.ashok.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Peoples {
	
	@FindBy(xpath="//a[text()='Add Person']")
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
	
	@FindBy(xpath="//div[@id='party:j_id325:0:phnDecorate']//span/input")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//div[@id='party:j_id325:0:phnDecorate']//span/div/select")
	private WebElement typeOfNumber;
	
	@FindBy(xpath="//div[@id='party:j_id342:0:emlDecorate']//span/div/select")
	private WebElement typeOfEmail;
	
	@FindBy(xpath="//div[@id='party:j_id342:0:emlDecorate']//span/input")
	private WebElement email;
	
	

}
