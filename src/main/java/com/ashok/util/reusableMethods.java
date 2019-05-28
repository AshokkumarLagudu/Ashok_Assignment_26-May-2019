package com.ashok.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class reusableMethods {

	//page scrolling down upto end
		public static void scrollPageDown(WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
		}
		
		//page scrolling upto given location
		public static void scrollPageDown(WebDriver driver,String num){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, "+ num+")");
			
		}
		
		//page scrolling upto element visibile
		public static void scrollPageToView(WebDriver driver,WebElement element){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			
			js.executeScript("arguments[0].scrollIntoView();",element );
		}
		
		//click on element using javaScripExecuter
		public static void clickOnElement(WebDriver driver,WebElement element){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click()", element);
		}
}
