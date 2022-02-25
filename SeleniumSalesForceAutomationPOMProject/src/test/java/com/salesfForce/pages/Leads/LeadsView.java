package com.salesfForce.pages.Leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class LeadsView extends BasePage{

	public LeadsView(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='lea3']") WebElement addessText ;
	@FindBy(xpath="//input[@title='New']") WebElement newButton;
	@FindBy(xpath="//input[@id='name_lastlea2']") WebElement lastText;
	@FindBy(id="tryLexDialogX")WebElement lightDialogue;
	@FindBy(xpath="//td[@class='pbButtonb']//input[@title='Save']")WebElement saveButton;
	@FindBy(xpath ="//select[@title='View:']") WebElement toDaysLead;
	@FindBy(xpath ="//h2[@class='topName']") WebElement namechangedPage;
	
	public boolean newLeadPage() 
	{   waitUntilVisible(toDaysLead);
		waitUntilVisible(newButton);
		clickElement(newButton);
		report.logTestInfo("new button is clicked");
		
		String newLeadTitle=	driver.getTitle();
		if(newLeadTitle.contains("New Lead"))
		return true;
		else 
			return false;
		}
	public boolean NewLeadSaved() {
		waitUntilVisible(saveButton);
		lastText.sendKeys("ABCD");
		addessText.sendKeys("ABCD");
		waitUntilVisible(saveButton);
		clickElement(saveButton);
		waitUntilVisible(namechangedPage);
		String abcdTitle=driver.getTitle();
		report.logTestInfo("title of the page is="+abcdTitle);
		if(abcdTitle.contains("ABCD"))
			return true;
		else return false;
			
	}
}
		
	
	

