package com.salesfForce.pages.Accounts;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class AccountReport extends BasePage{

	public AccountReport(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//a[text()='Accounts with last activity > 30 days']") WebElement reportLinktBtn;
	@FindBy(xpath ="//h2[@class='pageDescription']") WebElement reportPage;
	@FindBy(xpath ="//img[@id='ext-gen148']") WebElement dateField;
	@FindBy(xpath ="//div[contains(text(),'Created Date')]") WebElement createdDate;
	@FindBy(xpath ="//input[@id='ext-comp-1042']") WebElement todaydateField;
	@FindBy(xpath ="//input[@id='ext-comp-1045']") WebElement todaydateToField;
	@FindBy(xpath ="//button[@id='ext-gen49']") WebElement saveBtn;
	@FindBy(xpath ="//input[@name='reportName']") WebElement reportName;
	@FindBy(xpath ="//input[@name='reportDevName']") WebElement reportUniqueName;
	@FindBy(xpath ="//button[@id='ext-gen319']") WebElement saveNRunBtn;
	@FindBy(id ="tryLexDialogX") WebElement lightDialogue;
	@FindBy(xpath ="//div[@class='x-grid3-row x-grid3-row-first x-grid3-row-selected']//table[@class='x-grid3-row-table']//tr//td") WebElement tableReport;
	@FindBy(xpath ="//table[@class='x-grid3-row-table']") WebElement reportTable;
	@FindBy(xpath ="//input[@id='saveReportDlg_reportNameField']") WebElement reportName1;
	@FindBy(xpath ="//input[@id='saveReportDlg_DeveloperName']") WebElement reporUniqueName;
	@FindBy(xpath ="//button[@id='ext-gen49']") WebElement saveReBtn;
	@FindBy(xpath ="//button[@id='ext-gen281']") WebElement saveNRunReportBtn;
	
	
	
	
	public boolean createAccountReport()
	{
		
		waitUntilVisible(reportLinktBtn);
		
		clickElement(reportLinktBtn);
		waitUntilVisible(reportPage);
	    String reportPageText=reportPage.getText();
	    if(reportPageText.equalsIgnoreCase("Unsaved Report"))
	    	return true;
	    	else
	    		return false;
		
	}
	public boolean selectReportOption()
	{
		waitUntilVisible(dateField);
		   clickElement(dateField);
		   waitUntilVisible(createdDate);
		   clickElement(createdDate);
		   Calendar cal = Calendar.getInstance();
		   cal.add(Calendar.MONTH, -1);
		   SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		   String currentDate=dateOnly.format(cal.getTime());
		   todaydateField.sendKeys(currentDate);		  
		   Calendar cal1 = Calendar.getInstance();
		   SimpleDateFormat dateOnly1 = new SimpleDateFormat("MM/dd/yyyy");
		   String currentDate1=dateOnly1.format(cal.getTime());
		   todaydateToField.sendKeys(currentDate1);
		   clickElement(saveReBtn);
		   clickElement(createdDate);
		   String name="chi";
		   reportName1.sendKeys(name);
		   reporUniqueName.sendKeys("chi_12");
		   waitUntilDisplayed(saveNRunReportBtn);
		   clickElement(saveNRunReportBtn);
		   if(driver.getTitle().contains(name))
			   return true;
		   else return false;
		   
		   
		 	}
	
	

}
