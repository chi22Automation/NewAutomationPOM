package com.salesfForce.pages.Leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class LeadsHome extends BasePage
{

	public LeadsHome(WebDriver driver1)
	{
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//span[@id='userNavLabel']") WebElement userMenu;
	@FindBy(xpath="//img[@title='Leads']") WebElement leadLink;
	@FindBy(xpath="//a[@title='Logout']") WebElement logOut;
	@FindBy(id="tryLexDialogX")WebElement lightDialogue;//a[@class='listRelatedObject leadBlock title']
	@FindBy(xpath ="//li[@id='AllTab_Tab']") WebElement plusAllTabs;
	@FindBy(xpath ="//select[@title='View:']") WebElement toDaysLead;
	@FindBy(xpath ="//input[@title='Go!']") WebElement goBtn;

	String prevSessionDefaultSelection="";
	public  boolean LeadpageVerification()
	{
//		 if(driver.getWindowHandles().size()>1)
//			 callLightningAlert();
			waitUntilVisible(plusAllTabs);
		clickElement(plusAllTabs);
//		if(driver.getWindowHandles().size()>1)
//			callLightningAlert();
		waitUntilVisible(leadLink);
		clickElement(leadLink);
         waitUntilVisible(toDaysLead);
		String leadTitle=driver.getTitle();
		System.out.println("title of the page is="+leadTitle);
//		 if(driver.getWindowHandles().size()>1)
//			 callLightningAlert();
report.logTestInfo("title of the pagelead is:  "+leadTitle);
			if(leadTitle.equalsIgnoreCase("Leads: Home ~ Salesforce - Developer Edition"))
				return true;
			else
				return false;
		}
		public  boolean leadDropDownMenuverification()
		{
			//All Open Leads / My Unread Leads / Recently Viewed Leads / Today's Leads

			String[] exp={"All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads", "View - Custom 1", "View - Custom 2"};
			List<WebElement> items= driver.findElements(By.xpath("//select[@title='View:']//option"));
			System.out.println("no of items are"+items.size()); 
			boolean match = false;
			for(WebElement we:items)  
			{ 	System.out.println("here"+we.getText());	
			for (int i=0; i<exp.length; i++){
				if (we.getText().equalsIgnoreCase(exp[i])){
					match = true;
				}
			}
			}
			return match;
		}
		public void callLightningAlert()
		{
			 { report.logTestInfo("number of windows present arelTitle"+driver.getWindowHandles().size());
				if (lightDialogue.isDisplayed()) {
					lightDialogue.click();
						}
				 }
		}
		public void TodaysLeadLogOut()
		{   //Select selQReport3=new Select(toDaysLead); 
			prevSessionDefaultSelection= selectByIndexVisibleData1(toDaysLead,"Today's Leads");
		//System.out.println(selQReport1.getFirstSelectedOption().getText());
		report.logTestInfo("selection in drop down is"+prevSessionDefaultSelection);
		waitUntilVisible(userMenu);
		clickElement(userMenu);	
		waitUntilVisible(logOut);
		clickElement(logOut);

		}
		public boolean ReLoginSelectionAndGoBtnClick()
		{  boolean todylead=false;
			waitUntilVisible(goBtn);
		     clickElement(goBtn);
		     report.logTestInfo("after clicking go button");
			Select selQReport3=new Select(toDaysLead);
			report.logTestInfo("selected option is"+selQReport3.getFirstSelectedOption().getText());
			report.logTestInfo("previous dropdown selection"+prevSessionDefaultSelection);
			if(selQReport3.getFirstSelectedOption().getText().equalsIgnoreCase(prevSessionDefaultSelection))
				todylead= true;
			else 
				todylead= false;
			return todylead;
		}
		public boolean todayLeadSelection()
		{   
			 report.logTestInfo("before clicking todays lead");
			
			Select selQReport3=new Select(toDaysLead);
			if(selQReport3.getFirstSelectedOption().getText().equalsIgnoreCase("Today's Leads"))
				return true;
			else 
				return false;
		}


	}
	