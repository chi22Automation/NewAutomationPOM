package com.salesForce.base;
import java.io.File;




import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;

import com.salesForce.utility.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static GenerateReports report=GenerateReports.getInstance();
	
	
	public BasePage(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}
	
	
	public static void closeDriver() {
		driver.close();
	}
	
	public static void closeAllDriver() {
		driver.quit();
	}
	/* name of the method:   enterText
	 * BriefDescription  :   entering textvalue for textbox
	 * Arguments         :  element-->web element
	 *                      text--->to be entered 
	 *            
	 *  createdby        :  Automation team 
	 *  created date     :01/20/22 
	 *  LastModified Date:01/20/22          
	 */
	public static void enterText(WebElement element,String text) {
		waitUntilVisible(element);
		if(element.isDisplayed()) {
			clearElement(element);
			element.sendKeys(text);
			System.out.println("pass: text entered");
			report.logTestInfo("username entered");
		}
		else {
			System.out.println("fail: element not displayed");
		}
	}
	public static void clickElement(WebElement element) {
		if(element.isDisplayed()) {
			element.click();
			System.out.println("pass: element clicked");
		}
		else {
			System.out.println("fail: element not displayed");
		}
	}
	
	public static void clearElement(WebElement element) {
		if(element.isDisplayed()) {
			element.clear();
			System.out.println("pass: element cleared");
		}
		else {
			System.out.println("fail: element not displayed");
		}
	}
	public static void waitUntilDisplayed(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitUntilVisible(WebElement element) {
		wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(element));
		report.logTestInfo("waiting for the element to be visible");
	}
	public static void waitUntilAlertIsPresent() {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void mouseOver(WebElement element) {
		waitUntilVisible(element);
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void AcceptAlert() {
		waitUntilAlertIsPresent();
		Alert alert=driver.switchTo().alert();
		System.out.println("alert text="+alert.getText());
		alert.accept();
		System.out.println("alert accepted");
		
	}
	public static void dissmisAlert() {
		waitUntilAlertIsPresent();
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		
	}
	public static void selectByTextData(WebElement element,String text) {
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		report.logTestInfo("selectByTextData method selected the data");
	}
	public static void selectByIndexData(WebElement element,int index) {
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
	}
	public static void selectByIndexVisibleData(WebElement element,String text) {
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		//String prevSessionDefaultSelection= selectCity.getFirstSelectedOption().getText();
	}
	public static String selectByIndexVisibleData1(WebElement element,String text)
	{
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		String prevSessionDefaultSelection= selectCity.getFirstSelectedOption().getText();
		return prevSessionDefaultSelection;
	}
	public static void selectByValueData(WebElement element,String text) {
		Select selectCity = new Select(element);
		selectCity.selectByValue(text);
	}
	
	public static String getTitleOfThePage(WebElement element) {
		waitUntilVisible(element);
		return driver.getTitle();
	}
	public static String getErrorText(WebElement element) {
		waitUntilVisible(element);
		return element.getText();
	}
	public static String getTextBoxData(WebElement element)
	{
		waitUntilVisible(element);
		String textData=element.getText();
	    return textData;
		
	}
	

	}

