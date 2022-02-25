package com.salesfForce.pages.Accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class AccountMerge extends BasePage{

	public AccountMerge(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//a[text()='Merge Accounts']") WebElement mergeLink;
	@FindBy(xpath ="//div[@class='pbWizardBody']//input[1]") WebElement accountName;
	@FindBy(xpath ="//input[@value='Find Accounts']") WebElement findAccount;
	@FindBy(xpath ="//th[@scope='row']") WebElement accRow;
	@FindBy(xpath ="//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]") WebElement next;
	@FindBy(xpath ="//h1[contains(text(),'Merge My Accounts')]") WebElement mergeMyAcc;//h1[@class='noSecondHeader pageType']
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/th[1]/input[1]") WebElement mergeMyAccFirstRow;
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/th[1]/input[1]") WebElement mergeMyAccSecondRow;
	@FindBy(xpath ="//div[@class='pbTopButtons']//input[@title='Merge']") WebElement merge;
	@FindBy(xpath ="/select[@id='hotlist_mode']") WebElement selectVieDropBox;
	@FindBy(xpath ="//h2[@class='pageDescription']") WebElement accountPage;
	@FindBy(xpath ="//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]") WebElement nextBtn;
	//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]
	@FindBy(id ="tryLexDialogX") WebElement lightDialogue;
	//h2[@class='pageDescription']


	public boolean mergeAccount() 
	{
		boolean isAccountMerge=false;
		waitUntilVisible(mergeLink);
		clickElement(mergeLink);//div[@class='pbWizardBody']//input[2]
		accountName.sendKeys("nir");		
		waitUntilVisible(findAccount);
		clickElement(findAccount);
		// WebElement accrow = driver.findElement(By.xpath("//th[@scope=\"row\"]"));
		// System.out.println(accRow.getSize());
//		if(!(accRow.getSize().equals(0)))
//		{
			
			if(mergeMyAcc.isDisplayed())
			{
				if(!mergeMyAccFirstRow.isSelected())
				{
					mergeMyAccFirstRow.click();
					System.out.println("first checkbox click");
				}
				if(!mergeMyAccSecondRow.isSelected())
				{
					mergeMyAccSecondRow.click();
					System.out.println("second checkbox click");
				}
				

       clickElement(nextBtn);
			}
//		}
		
            waitUntilDisplayed(merge);
            clickElement(merge);
            AcceptAlert();
	
		selectByTextData(selectVieDropBox, "Recently Viewed");
		if(driver.getTitle().contains("Account: Home"))
		{ isAccountMerge= true;
		}

		else 
		{ isAccountMerge= false;}

		return isAccountMerge;
	}
}


