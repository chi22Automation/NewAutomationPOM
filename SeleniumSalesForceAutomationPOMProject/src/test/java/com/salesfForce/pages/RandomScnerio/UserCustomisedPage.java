package com.salesfForce.pages.RandomScnerio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesForce.base.BasePage;

public class UserCustomisedPage extends BasePage {

	public UserCustomisedPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//img[@title='All Tabs']")  WebElement pluslink ;
	@FindBy(xpath ="//input[@name='customize']")  WebElement customsedBtn ;
	
	
	
	public void customizedMyTab()
	{
		waitUntilVisible(pluslink);
		clickElement(pluslink);
		report.logTestInfo("plus is clicked");
		waitUntilVisible(customsedBtn);
		clickElement(customsedBtn);
		report.logTestInfo("custom link is clicked");
		
	}

}
