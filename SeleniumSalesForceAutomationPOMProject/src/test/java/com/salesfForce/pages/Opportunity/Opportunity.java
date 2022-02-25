package com.salesfForce.pages.Opportunity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesForce.base.BasePage;

public class Opportunity extends BasePage{

public Opportunity(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath ="//a[@class='listRelatedObject opportunityBlock title']" ) WebElement opportunityTab;//a[@class='listRelatedObject opportunityBlock title']
@FindBy(xpath ="//span[@id='userNavLabel']" ) WebElement userMenu;
@FindBy(xpath ="//li[@id='AllTab_Tab']") WebElement plusAllTabs;
@FindBy(xpath ="//select[@title='View:']//option") WebElement viewOption;

public void opprtuTabClick()
{
	waitUntilVisible(plusAllTabs);
	clickElement(plusAllTabs);
	System.out.println("aall tab is clicked");
	//waitUntilVisible(opportunityTab);
	waitUntilDisplayed(opportunityTab);
	clickElement(opportunityTab);
	report.logTestInfo("pipleline Link clicked");

}

public  boolean oprtunityPageAndUserNameVerification()
{
	 opprtuTabClick();
	 
	 boolean result=false;
	 String title=driver.getTitle();
	 //Assert.assertTrue(title.contains("Home"));
	  String titleuser= userMenu.getText();
	 System.out.println(titleuser);
	// if((title.contains("Home Page"))&& (titleuser=="c Chh"))
	 if((title.contains("Opportunities")) && (titleuser.equalsIgnoreCase("c Chh")))
		 //isOpportunities
	 {
		 System.out.println("title is"+title);
	
		 result=true;
	 }
	 else
	 {
		 System.out.println("title is in false cond"+title);
		 
		 result= false;
	 }
	 return result;
}
public  boolean OPortunityDropDownMenuverification()
{
	
	
	String[] exp={"All Oppotunities", "Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities","Won"  };
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
}