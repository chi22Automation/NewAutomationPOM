package com.salesfForce.pages.Contacts;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class ContactNewView extends  BasePage{

	public ContactNewView(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//span//a[2]") WebElement newView;
	@FindBy(xpath="//tbody/tr[1]/td[2]/div[1]/input[1]") WebElement viewName;
	@FindBy(xpath="//input[@name='devname']") WebElement viewUniqueName;
	@FindBy(xpath="(//input[@data-uidsfdc='3'])[1]") WebElement saveContact;
	@FindBy(xpath="(//div[@class='errorMsg'])[1]") WebElement viewNameErrorMessage;
	@FindBy(xpath="(//input[@title='Cancel'])[2]") WebElement cancelBtn;
	
	public boolean createNewView()
	{
		waitUntilVisible(newView);
		clickElement(newView);
		waitUntilVisible(viewName);
		
		viewName.sendKeys("geet");
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		String name="geet"+"_"+(rand.nextInt(upperbound));
		
		waitUntilVisible(viewUniqueName);		
		//viewUniqueName.sendKeys(name);
		viewUniqueName.clear();
		//waitUntilVisible(viewUniqueName);		
		viewUniqueName.sendKeys(name);		
		waitUntilVisible(saveContact);
		clickElement(saveContact);
		String contactHomePage=driver.getTitle();
		if(contactHomePage.contains("Contact"))
			return true;
		else return false;
	}
	public boolean errormessage()
	{
		waitUntilVisible(newView);
		clickElement(newView);
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		String name="geet"+"_"+(rand.nextInt(upperbound));
		//div[@class='errorMsg'])[1]
		WebElement viewUniqueName=driver.findElement(By.xpath("//input[@name='devname']"));
		waitUntilVisible(viewUniqueName);		
		viewUniqueName.sendKeys(name);
		viewUniqueName.sendKeys(name);
		waitUntilVisible(saveContact);
		clickElement(saveContact);
			 
			 System.out.println(viewNameErrorMessage.getText());
			 if(viewNameErrorMessage.getText().equalsIgnoreCase("Error: You must enter a value"))
				 return true;
			 else return false;
	}
	public boolean cancelContact()
	{
		waitUntilVisible(newView);
		clickElement(newView);
		waitUntilVisible(viewName);		
		viewName.sendKeys("ABCD");
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		String name="ABCD"+"_"+(rand.nextInt(upperbound));
		waitUntilVisible(viewUniqueName);
		viewUniqueName.sendKeys(name);
		 waitUntilVisible(cancelBtn);
		 clickElement(cancelBtn);
		  String contactHomePage=driver.getTitle();
			if(contactHomePage.contains("Home"))
				 return true;
			else return false;
	}

}
