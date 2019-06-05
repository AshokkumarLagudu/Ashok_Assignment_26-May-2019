package com.pageTest;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ashok.base.Base;
import com.ashok.pages.Cases;
import com.ashok.pages.HomePage;
import com.ashok.pages.LoginPage;
import com.ashok.pages.Peoples;
import com.ashok.util.Read_XL_Data;
import com.ashok.util.Utils;


public class TestCase_001 extends Base {

	public LoginPage loginpage;
	public Peoples peoples;
	public HomePage homepage;
	public Cases cases;
	private static String fname = "";
	private static String lname = "";
	private static String title="";
	private String newcaseName="";

	public TestCase_001() {
		super();

	}

	// Application Initialization
	@BeforeClass
	public void openBrowser() {
		initialization();
		loginpage = new LoginPage();
		peoples = new Peoples();
		homepage = new HomePage();

	}

	@BeforeClass(dependsOnMethods = { "openBrowser" })
	public void loginToAccount() {

		try {
			loginpage.enterUsername(prop.getProperty("userName"));
			loginpage.enterPassword(prop.getProperty("password"));
			loginpage.clickOnLogin();
		} catch (Exception e) {
			loginpage.enterUsername(prop.getProperty("userName"));
			loginpage.enterPassword(prop.getProperty("password"));
			loginpage.clickOnLogin();
		}
		String title = driver.getTitle();
		if(!prop.getProperty("accountName").isEmpty()){
		Assert.assertEquals(title, "Dashboard | "+prop.getProperty("accountName")+" CRM");
		}

	}

	@Test(priority = 2, enabled = true)
	public void click_On_Person() {

		homepage.clickOnPeople();
		
		peoples.click_On_add_Person();
	}

	@Test(priority = 3, enabled = true, dataProvider = "peopleData")
	public void add_New_Peoples_Data(String key, String value) {

		if (key.equalsIgnoreCase("FirstName")) {
			fname = value;
			 
			
		}else if(key.equals("LastName")){
			lname=value;
		}else if(key.equals("Title")){
			title=value;
		}

		peoples.fill_User_Details(key, value);

		if (key.equals("ZipCode")) {
			peoples.click_On_Save();
         String newPersonName=title+" "+fname+" "+lname;
         Assert.assertEquals(peoples.get_Added_New_PersonName(), newPersonName);
			
		}

	}

	@Test(priority = 4)
	public void click_On_Cases() throws InterruptedException {
		cases=homepage.clickOnCases();
		Thread.sleep(1000);
		String title = driver.getTitle();
		if(!prop.getProperty("accountName").isEmpty()){
			Assert.assertEquals(title, "Cases | "+prop.getProperty("accountName")+" CRM");
		}
		
		cases.click_On_AddCase();
		Assert.assertEquals(cases.get_newCase_text(), "New Case");

	}

	@Test(priority = 5, enabled = true, dependsOnMethods = { "click_On_Cases" }, dataProvider = "caseData")
	public void fill_New_Cases(String key, String value) {
      
		cases.fill_New_Case_Form(key, value);
		
		if(key.equals("Name*")){
			newcaseName=value;
		}

		if (key.equals("Tags")) {
			cases.click_On_Save();
			Assert.assertEquals(cases.get_newCase_Name(), newcaseName);
			Assert.assertEquals(cases.get_Case_Status(), "Open");
			
			
		}

	}

	@DataProvider(name = "peopleData")
	public Object[][] data() {

		Object[][] data = Read_XL_Data.getTableData(Utils.ExcelFilePath, "AddPerson");
		return data;

	}

	@DataProvider(name = "caseData")
	public Object[][] case_data() {

		Object[][] data = Read_XL_Data.getTableData(Utils.ExcelFilePath, "Case");
		return data;

	}

	@AfterClass
	public void closeBrowser() {
		killBrowser();
	}

}

