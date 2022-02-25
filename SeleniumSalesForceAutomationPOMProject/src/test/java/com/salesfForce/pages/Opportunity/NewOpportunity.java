package com.salesfForce.pages.Opportunity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class NewOpportunity extends BasePage{

	public NewOpportunity(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@title='New']") WebElement newBtn;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']") WebElement saveBtn;
	@FindBy(xpath="//input[@id='opp3']") WebElement oprtuName;
	@FindBy(xpath="//input[@id='opp4']") WebElement accountName;
	@FindBy(xpath="//input[@id='opp9']") WebElement closeDate;
	@FindBy(xpath="//input[@id='opp12']") WebElement probability;
	@FindBy(xpath="//select[@id='opp6']") WebElement leadSource;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']") WebElement primaryCampaign;
	@FindBy(id ="tryLexDialogX") WebElement lightDialogue;
	@FindBy(xpath="//select[@id='opp11']") WebElement stage;
	@FindBy(xpath="//h2[@class='pageDescription']") WebElement newoppage;
	
	
	public boolean createNewOptunty() {
		
		waitUntilDisplayed(newBtn);
		clickElement(newBtn);
		
		waitUntilDisplayed(oprtuName);
		String newoptu="operator";
		oprtuName.sendKeys(newoptu);
		report.logTestInfo(driver.getTitle());
		accountName.sendKeys("geet14");
		closeDate.sendKeys(getDate());
		report.logTestInfo(getDate());
		probability.sendKeys("10");
		selectByIndexData(leadSource,3);
		selectByIndexData(stage,3);
		//primaryCampaign.sendKeys("");
		waitUntilDisplayed(saveBtn);
		clickElement(saveBtn);
		waitUntilVisible(newoppage);
		report.logTestInfo(driver.getTitle());
		if(driver.getTitle().contains(newoptu))
			
			return true;
			else
				return false;
		
	}
	public String getDate() {
		Calendar cal = Calendar.getInstance();
		  cal.add(Calendar.MONTH, +1);
		   SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		   String currentDate=dateOnly.format(cal.getTime());
		   return currentDate;
	}
	  

}
