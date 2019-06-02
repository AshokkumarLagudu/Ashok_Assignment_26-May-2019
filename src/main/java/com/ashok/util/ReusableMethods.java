package com.ashok.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class ReusableMethods {

	public static Properties load_Propeties_File(String filePath){
		 Properties prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(new File(filePath));
			prop.load(fis);
			return prop;
		} catch (FileNotFoundException e) {
			
			System.out.println("Properties File not found at given location");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	//page scrolling down upTo end
		public static void scrollPageDown(WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
		}
		
		//page scrolling upTo given location
		public static void scrollPageDown(WebDriver driver,String num){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, "+ num+")");
			
		}
		
		//page scrolling upTo element visible
		public static void scrollPageToView(WebDriver driver,WebElement element){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			
			js.executeScript("arguments[0].scrollIntoView();",element );
		}
		
		//click on element using javaScripExecuter
		public static void clickOnElement(WebDriver driver,WebElement element){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click()", element);
		}
		
		public static void selectByText(WebElement element,String text){
			
			Select select=new Select(element);
			
			select.selectByVisibleText(text);
		}
		
		
}
