package com.salesfForce.pages.Home;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class MySettingsPage extends BasePage
{
	public MySettingsPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//span[@id='userNavLabel']") WebElement userMenu;
	@FindBy(xpath ="//a[@title='My Settings']")  WebElement  userMenumySettinge;

	@FindBy(xpath ="//span[text()='My Settings']")  WebElement  mySettingTitle;
	@FindBy(xpath ="//div//a//span[@id='PersonalInfo_font']") WebElement personal;
	@FindBy(xpath ="//span[@id='LoginHistory_font']") WebElement historyLogin;
	//@FindBy(xpath ="//a[@id='LoginHistory_font']") WebElement downloadhistoryLogin;
	@FindBy(xpath ="//div[@class='pShowMore']//a") WebElement downloadhistoryFileISCSV;

	@FindBy(xpath ="//span[@id='DisplayAndLayout_font']") WebElement displayAndLayout;
	@FindBy(xpath ="//span[@id='CustomizeTabs_font']") WebElement customiseTab;
	@FindBy(xpath ="//select[@id='p4']") WebElement customtab;
	@FindBy(xpath ="//tbody/tr[1]/td[1]/select[1]") WebElement availableTab;
	@FindBy(xpath ="//tbody/tr/td[3]/select[1]") WebElement selectedTab;
	@FindBy(xpath ="//img[@title='Add']") WebElement addbtn;
	@FindBy(xpath ="//input[@title='Save']") WebElement savebtn;
	@FindBy(xpath ="//span[@id='EmailSetup_font']")WebElement emailSetupLink;
	@FindBy(xpath ="//span[@id='EmailSettings_font']") WebElement emailSetting;
	@FindBy(xpath ="//input[@id='sender_name']") WebElement emailName;
	@FindBy(xpath ="//input[@value='chitraemail22@gmail.com']") WebElement emailId;
	@FindBy(xpath ="//tbody/tr[7]/td[1]") WebElement radioBtn;
	@FindBy(xpath ="//input[@title='Save']") WebElement saveBtn;
	@FindBy(xpath ="//span[@id='CalendarAndReminders_font']") WebElement calenderNReminder;
	@FindBy(xpath ="//span[@id='Reminders_font']") WebElement activityReminder;
	@FindBy(xpath ="//input[@id='testbtn']") WebElement openBtn;



	/**
	 * @param mySettingTitle the mySettingTitle to set
	 */
	public void setMySettingTitle(WebElement mySettingTitle) {
		this.mySettingTitle = mySettingTitle;
	}
	public WebElement getMySettingTitle() {
		return mySettingTitle;
	}
	public  boolean checkTitleofSetting()
	{
		if(mySettingTitle.getText().equalsIgnoreCase("My Settings"))
			return true;
		else
			return false;

	}
	public boolean downloadLoginHistory()
	{
		waitUntilVisible(personal);
		clickElement(personal);
		report.logTestInfo("Personal link is clicked");
		waitUntilVisible(historyLogin);
		clickElement(historyLogin);
		waitUntilVisible(downloadhistoryFileISCSV);
		clickElement(downloadhistoryFileISCSV);
		if(downloadhistoryFileISCSV.getText().contains(".csv"))
			return true;
		else
			return false;

	}
	public boolean displayAndlayOut()
	{
		clickElement(displayAndLayout);
		clickElement(customiseTab);
		Select customtab1 = new Select(customtab);
		customtab1.selectByVisibleText("Salesforce Chatter");
		Select availableTab1 = new Select(availableTab);
		List <WebElement> op = availableTab1.getOptions();
		System.out.println( op.get(5).getText());
		int size = op.size();
		for(int i =0; i<size ; i++){
			if(!op.get(i).getText().equalsIgnoreCase("Reports"))
			{
				break;
			}
			else
			{
				availableTab1.selectByVisibleText("Reports");
				clickElement(addbtn);
				clickElement(savebtn);

			}
		}
		boolean added=ifReportIsInAddedTab("Salesforce Chatter");
		boolean added1=ifReportIsInAddedTab("Sales");
		boolean added2=ifReportIsInAddedTab("Marketing ");
		if(added&&added1&&added2)
			return true;
		else return false;
	}
	public  boolean ifReportIsInAddedTab(String str)
	{
		
		
	     Select customtab1 = new Select(customtab);
			customtab1.selectByVisibleText("Salesforce Chatter");
			Select selectedTabItems=new Select(selectedTab);
			 List <WebElement>selop=	selectedTabItems.getOptions();
			 boolean added=false;
			 for(WebElement we:selop)
			 {
				 if(we.getAttribute("text").equalsIgnoreCase("Reports"))
					 added=true;
				 else
					 added=false;	 
				 
			 }
			 return added;
		
	}
	public boolean emailNameAndEmailSet()
	{
		Actions act=new Actions(driver);
		act.moveToElement(emailSetupLink).click().build().perform();
		clickElement(emailSetting);
		emailName.clear();
		emailName.sendKeys("Chitra");
		emailId.clear();
		emailId.sendKeys("Chitraemail22@gmail.com");
		radioBtn.click();
		if(radioBtn.isSelected())
		clickElement(saveBtn);
		Boolean emailsetup=checkTitleofSetting();
		return emailsetup;
	}
		public boolean calenderAndEvent()
		{
			Actions act=new Actions(driver);
			
			act.moveToElement(calenderNReminder).click().build().perform();
			report.logTestInfo("calender N reminder clicked");
			
			waitUntilVisible(activityReminder);
			clickElement(activityReminder);	
			report.logTestInfo("activity Reminder clicked");
			waitUntilVisible(openBtn);
			clickElement(openBtn);
			report.logTestInfo("open reminder button clicked");
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
                    .ignoring(NoSuchElementException.class);
			Set<String> windows =driver.getWindowHandles();
			report.logTestInfo("no of windows are "+windows.size());
			if(windows.size()>=1)
				return true;
			else return false;


		}

	}
	