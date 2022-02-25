package com.salesfForce.pages.Contacts;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class ContactEdit  extends  BasePage{

	public ContactEdit(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//tbody//tr//td[2]//input[@value=' New ']") WebElement newContact;
		@FindBy(xpath="//input[@id='name_lastcon2']") WebElement lastName;
	@FindBy(xpath="//span[@class='lookupInput']//input[@id='con4']") WebElement accountName;
	@FindBy(xpath="(//input[@value='Save & New'])[2]") WebElement saveAndNewContact;

	public boolean editAccount()
	{
		waitUntilVisible(newContact);
		clickElement(newContact);
		report.logTestInfo("new contact button is clicked");
		waitUntilVisible(lastName);
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		String name="ch"+(rand.nextInt(upperbound));
		lastName.sendKeys("Indian");
		waitUntilVisible(accountName);							
		accountName.sendKeys("Global Media");
		waitUntilVisible(saveAndNewContact);
		clickElement(saveAndNewContact);
		String contactHomePage=driver.getTitle();
		report.logTestInfo("title of after edit page is="+contactHomePage);
		if(contactHomePage.contains("Contact Edit"))
			 return true;
		else return false;
	}
	

}
