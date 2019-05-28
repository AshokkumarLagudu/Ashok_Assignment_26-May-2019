package com.pageTest;

import org.testng.annotations.BeforeClass;

import com.ashok.base.Base;
import com.ashok.pages.LoginPage;


public class loginPageTest extends Base {
	LoginPage loginpage;
	loginPageTest(){
		super();
	}
	
	// Application Initialization
		@BeforeClass
		public void openBrowser() {
			initialization();
			loginpage = new LoginPage();

		}

}
