package com.salesfForce.pages.Accounts;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;
public class AccountNew extends BasePage {

	public AccountNew(WebDriver driver1) {
 		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="(//input[@title='New'])[1]") WebElement newAccount;
	@FindBy(xpath ="//input[@id='acc2']") WebElement newNameAccount;
	@FindBy(xpath ="//td[@class='pbButton']//input[@title='Save']") WebElement savebtn;
	@FindBy(xpath ="//h2[@class='topName']") WebElement savedAccountTitleTxt;
	@FindBy(id ="tryLexDialogX") WebElement lightDialogue;
	public boolean createNewAccount()
	{
		//WebElement lightDialogue= driver.findElement(By.id("tryLexDialogX"));
		System.out.println(driver.getTitle());
		
		waitUntilDisplayed(newAccount);
		//waitUntilVisible(newAccount);
		clickElement(newAccount);
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		String name="geet"+(rand.nextInt(upperbound));
		newNameAccount.sendKeys("geet");
		clearElement(newNameAccount);		
		newNameAccount.sendKeys(name);
		//waitUntilAlertIsPresent();
		//waitUntilVisible(savebtn);
		waitUntilDisplayed(savebtn);
		clickElement(savebtn);	
		
		String text= savedAccountTitleTxt.getText();
		if(name.equalsIgnoreCase(text))
			return true;
		else
			return false;
		
	}
}
