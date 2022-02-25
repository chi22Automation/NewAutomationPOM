package com.salesfForce.pages.Contacts;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesForce.base.BasePage;

 public class ContactHome extends  BasePage{

	public ContactHome(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//img[@title='All Tabs']") WebElement AllTab;
	@FindBy(xpath="//a[@class='listRelatedObject contactBlock title']") WebElement contactLink;
	@FindBy(xpath="//tbody//tr//td[2]//input[@value=' New ']") WebElement newContact;
	
	@FindBy(xpath="//input[@id='name_lastcon2']") WebElement lastName;
	@FindBy(xpath="//span[@class='lookupInput']//input[@id='con4']") WebElement accountName;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']") WebElement saveContact;
	@FindBy(xpath="//select[@title='Display Selection']") WebElement RecentContact;
	@FindBy(xpath="//table[@class='list']//tr") WebElement recentContactList;
	@FindBy(xpath="//h3[normalize-space()='Recent Contacts']") WebElement recentContactPageTag;
	@FindBy(xpath="//select[@title='View:']") WebElement myContact;
	@FindBy(xpath="//h2[@class='topName']") WebElement newlyaddedContactDisplayed;
	@FindBy(xpath="(//span[@class='mruText'])[1]") WebElement myContactName;
	@FindBy(xpath="//div[@class='recycleBinModule sidebarModule']//div[@class='sidebarModuleBody sidebarModuleBodyNoHeader']") WebElement myrecycle;
	
	
	//td[@id='topButtonRow']//input[@title='Save']
	//tbody//tr//td//input[@title='Save'])[1]
	public  boolean contactHomepage()
	{
		waitUntilDisplayed(AllTab);
		//waitUntilVisible(AllTab);
		clickElement(AllTab);	
		report.logTestInfo("all tab clicked");
		waitUntilVisible(contactLink);
		clickElement(contactLink);
		report.logTestInfo("contact tab clicked");
		String contactTitle=driver.getTitle();
		if(contactTitle.contains("Contacts"))
			return true;
		else return false;
		
	
	}
	public Boolean newContact() 
	{
		waitUntilVisible(newContact);
		clickElement(newContact);
		waitUntilVisible(lastName);
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		String name="ch"+(rand.nextInt(upperbound));
		lastName.sendKeys(name);
		waitUntilVisible(accountName);		
		accountName.sendKeys("aar");
		waitUntilVisible(saveContact);
		clickElement(saveContact);
		waitUntilVisible(newlyaddedContactDisplayed);
		String newContactAdded=driver.getTitle();
		if(newContactAdded.contains(name))
			 return true;
		else return false;
	}
	public boolean recentContact()
	{
		Select selectRecentContact=new Select(RecentContact);
		selectRecentContact.selectByVisibleText("Recently Created");
		if(recentContactPageTag.getText().equalsIgnoreCase("Recent Contacts"))
			return true;
		else return false;
			
	}
	public boolean myContact()
	{
		Select selectMyContact=new Select(myContact);
		selectMyContact.selectByVisibleText("My Contacts");
		return true;
		
		
	}
	public boolean mycontactName() 
	{
		String clickedContactLink=myContactName.getText();
		report.logTestInfo(clickedContactLink);
		 clickElement(myContactName);
		 waitUntilVisible(myrecycle);
		 String clickedLinkTitlepage=driver.getTitle();
		 report.logTestInfo("title after clikng the name link is"+clickedLinkTitlepage);
		 if(clickedLinkTitlepage.contains(clickedContactLink))
			return true;
		 else return false;
	}
	
	
}
 