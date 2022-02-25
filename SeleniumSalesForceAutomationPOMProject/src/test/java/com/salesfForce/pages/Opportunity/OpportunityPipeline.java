package com.salesfForce.pages.Opportunity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class OpportunityPipeline extends BasePage{

	public OpportunityPipeline(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[normalize-space()='Opportunity Pipeline']") WebElement pipelineLink;
	@FindBy(xpath="//h2[text()='Report Generation Status:']") WebElement pipelineReportPage;
	
	@FindBy(id ="tryLexDialogX") WebElement lightDialogue;
	
	public boolean reportGenerate() {
		
	 
		waitUntilDisplayed(pipelineLink);
		clickElement(pipelineLink);
		waitUntilVisible(pipelineReportPage);
		if((pipelineReportPage.getText().contains("Report")) && (driver.getTitle().contains("Opportunity Pipeline"))) 
		return true;
		else return false;
				
	}
		
	}
	
