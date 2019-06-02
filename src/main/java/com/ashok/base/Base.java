package com.ashok.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ashok.util.DriverFactory;
import com.ashok.util.ReusableMethods;
import com.ashok.util.Utils;



public class Base {
	
	public static WebDriver driver=null;
	public static Properties prop=null;
	private static WebDriverWait wait;
	
	public Base(){
	
	prop=ReusableMethods.load_Propeties_File(Utils.propFilePath);
	
}

//Initialize the browser
public void initialization(){
	
	driver=DriverFactory.getDriver(prop.getProperty("browser"), prop.getProperty("url"));
	wait=new WebDriverWait(driver, Utils.wedriverWait);
}


public void takeScreenShot(String methodName) {
   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in the drive with test method name 
           try {
				FileUtils.copyFile(scrFile, new File(Utils.screenShotFilePath+methodName+"_failed.jpg"));
				System.out.println("***Placed screen shot in "+Utils.screenShotFilePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
   }

//wait until element clickable state and click
public void waitUntilElementclickable(WebElement element){
	
	wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	
}

//wait until element present
public void waitUntilElementVisible(WebElement element){
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void killBrowser(){
	driver.quit();
	if(driver!=null){
		driver=null;
	}
	


}
}
