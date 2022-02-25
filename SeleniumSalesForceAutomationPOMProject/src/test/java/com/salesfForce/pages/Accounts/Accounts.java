package com.salesfForce.pages.Accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.salesForce.base.BasePage;


public class Accounts extends BasePage {

	public Accounts(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//li[@id='AllTab_Tab']") WebElement plusAllTabs;
	@FindBy(xpath ="//a[@class='listRelatedObject accountBlock title']") WebElement account;
	@FindBy(xpath ="//a[@class='userMru']") WebElement userAccount;

	public void accountTabClick()
	{
		waitUntilVisible(plusAllTabs);
		clickElement(plusAllTabs);		
		waitUntilVisible(account);
		clickElement(account);

	}
	public boolean PageAndUserNameVerification()
	{
		boolean result=false;
		String title=driver.getTitle();		 
		System.out.println(title);
		String userverify=userAccount.getText();
		System.out.println(userverify);
		if((title.equalsIgnoreCase("Accounts: Home ~ Salesforce - Developer Edition")) && (userverify.equalsIgnoreCase("c Chh")))

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
}

