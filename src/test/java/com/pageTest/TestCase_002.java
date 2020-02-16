package com.pageTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ashok.base.Base;
import com.ashok.pages.Cases;
import com.ashok.pages.HomePage;
import com.ashok.pages.LoginPage;
import com.ashok.pages.Peoples;

public class TestCase_002 extends Base {
	public LoginPage loginpage;
	public Peoples peoples;
	public HomePage homepage;
	public Cases cases;
	public static Workbook workbook;
	public static Sheet sheet;
	private static XSSFRow row;
	private static FileInputStream ExcelFile;

	// TODO:Application Initialization
	@BeforeClass
	public void openBrowser() {
		initialization();
		loginpage = new LoginPage();
		peoples = new Peoples();
		homepage = new HomePage();

	}
	// TODO:Opening Browser
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
	
	@Test(priority=1,enabled=true)
	public void accountSettings(){
		
		String name=homepage.click_On_AccountName().getText();
		System.out.println(name);
		if(!prop.getProperty("accountName").isEmpty()){
			Assert.assertEquals(name, prop.getProperty("accountName"));
		}
		
		waitUntilElementclickable(homepage.click_On_AccountName());
		homepage.click_On_accoutnSettings();
	}
	//Closing browser
	@AfterClass
	public void closeBrowser(){
		killBrowser();
	}
	

}
