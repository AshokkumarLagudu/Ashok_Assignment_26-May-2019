package com.ashok.util;


import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {

	
	public final static int wedriverWait=30;
	public final static int pageloadTimeout=30;
	public final static int implicitWait=30;
	public final static String screenShotFilePath=System.getProperty("user.dir")+"\\Screenshots\\";
	
	//propeties file path
	public final static String propFilePath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\ashok\\config\\config.properties";
	
    public final static String ExcelFilePath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\ashok\\testData\\PeoplesData.xlsx";
	
}

