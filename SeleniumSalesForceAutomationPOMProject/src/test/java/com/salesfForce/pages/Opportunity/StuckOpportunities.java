package com.salesfForce.pages.Opportunity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class StuckOpportunities extends BasePage{

	public StuckOpportunities(WebDriver driver1)
	{
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[normalize-space()='Stuck Opportunities']") WebElement stuckoportunity;
	@FindBy(xpath="//h2[normalize-space()='Report Generation Status:']") WebElement pipelineReportPage;
	
	@FindBy(id ="tryLexDialogX") WebElement lightDialogue;
public boolean reportGenerate() 
{
		
		
	 
		waitUntilDisplayed(stuckoportunity);
		clickElement(stuckoportunity);
		waitUntilVisible(pipelineReportPage);
		if((pipelineReportPage.getText().contains("Report")) && (driver.getTitle().contains("Stuck Opportunities"))) 
		return true;
		else return false;
				
	}
		

}
