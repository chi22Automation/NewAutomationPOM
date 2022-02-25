package com.salesfForce.pages.RandomScnerio;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class CalenderNewEvent extends BasePage{

	public CalenderNewEvent(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//div[@id='tabContainer']//nav//ul//li[1]//a[1]") WebElement homeLinkBtn;
	@FindBy(xpath ="//span[@class='pageDescription']//a") WebElement curreentdate;
	@FindBy(xpath ="//h1[@class='pageType']") WebElement hoalenderForFNLNameme;
	@FindBy(xpath ="//div[29]//a[1]") WebElement curreentdate8PM;
	@FindBy(xpath ="//tbody/tr[2]/td[2]/div[1]/input[1]") WebElement expectedElement;
	@FindBy(xpath ="//tbody/tr[2]/td[2]/div[1]/input[1]") WebElement curreentEvent;
	@FindBy(xpath ="//img[@title='Subject Combo (New Window)']") WebElement comboBox;
	@FindBy(xpath ="//li[@class='listItem4']//a") WebElement other;
	@FindBy(xpath ="//div[@class='hourPicker']") List	<WebElement> listEndTimeavailable;
	@FindBy(xpath ="//td[@class='labelCol'])[5]") WebElement startTime;
	@FindBy(xpath ="//div[@id='simpleTimePicker']") WebElement endTime;
	@FindBy(xpath ="//td[@class='pbButtonb']//input[@title='Save']")WebElement saveBtn;
	@FindBy(xpath ="//div[@class='hourPicker']") WebElement calenderForFNLNameme;
	@FindBy(xpath ="//td[@class='dataCol last'])[1]") WebElement endTime1;//
	@FindBy(xpath ="//div[@class='hoverOuter'])[1]") WebElement otherLink;
	@FindBy(xpath ="//div[21]//a[1]") WebElement curreentElement4PM;
	@FindBy(xpath ="//tr[@class='detailRow']//input[@value='1']") WebElement recurring;
	@FindBy(xpath ="//label[normalize-space()='Frequency']") WebElement frequency;
	@FindBy(xpath ="//label[@for='RecurrenceStartDateTime']") WebElement startDate;
	@FindBy(xpath ="//label[@for='RecurrenceEndDateOnly']") WebElement endDate;
	@FindBy(xpath ="//input[@value='ftw']") WebElement weeklyRadioBtn;
	@FindBy(xpath ="//input[@title='specify interval in weeks']") WebElement RecurEvery;
	@FindBy(xpath ="//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[8]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[2]//input")  List<WebElement> checkboxCurrentDay;
	@FindBy(xpath ="//input[@id='RecurrenceEndDateOnly']") WebElement endDatecalender;
	
	//@FindBy(xpath ="//tbody/tr[2]/td[2]/div[1]/input[1]") WebElement expectedElement;
	
	
	
	String currentwindow2="";
	String calenderText="";
	
	public boolean calanderCurrentDateLink()
	{
		waitUntilVisible(homeLinkBtn);
		clickElement(homeLinkBtn);
		waitUntilVisible(curreentdate);
		clickElement(curreentdate);
		waitUntilVisible(hoalenderForFNLNameme);
		 calenderText=hoalenderForFNLNameme.getText();
		if(calenderText.equalsIgnoreCase("Calendar for c Chh"))
		return true;
		else
			return false;
		
	}
	public boolean newEvent()
	{
		waitUntilVisible(curreentdate8PM);
		clickElement(curreentdate8PM);
		String currentwindow1=driver.getWindowHandle();
		//driver.switchTo().window(currentwindow1);
		
		WebElement focus=	driver.switchTo().activeElement();
		expectedElement.equals(driver.switchTo().activeElement());
		//tbody/tr[2]/td[2]/div[1]/input[1]
		System.out.println("correct cursor location");
		
		if(curreentEvent.getText().equalsIgnoreCase("New Event"))
		{
			System.out.println("correct page is Event ");
		    return true;}
		else 
		{
			return false;}
		
	}
	public boolean newEvent4PM()
	{
		
		waitUntilVisible(curreentElement4PM);
		clickElement(curreentElement4PM);
		String currentwindow1=driver.getWindowHandle();
		//driver.switchTo().window(currentwindow1);
		WebElement expectedElement= driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div[1]/input[1]"));
		WebElement focus=	driver.switchTo().activeElement();
		expectedElement.equals(driver.switchTo().activeElement());
		//tbody/tr[2]/td[2]/div[1]/input[1]
		System.out.println("correct cursor location");
		if(curreentEvent.getText().equalsIgnoreCase("New Event"))
		
		{
			System.out.println("correct page is Event ");
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void comboBoxClicked()
	{
		 currentwindow2=driver.getWindowHandle();
		waitUntilVisible(comboBox);
		clickElement(comboBox);
		System.out.println("combobox is clicked");
		String otherText="";
		Set <String> windows =driver.getWindowHandles();
		for(String window1:windows)
		{
			if(!window1.equals(currentwindow2))
			{
				driver.switchTo().window(window1);
				System.out.println("comboBox window opened");
			
				waitUntilVisible(other);
				otherText=other.getText();
				System.out.println("text after clicking other is"+otherText);
				clickElement(other);
				break;

			}
		}
		
	}
	public void clickTheTime(String time) 
	{ 
		boolean timeIsCorrect=false;
		driver.switchTo().window(currentwindow2);
		System.out.println("before endtime");
		//WebElement endTime = driver.findElement(By.xpath("//div[@class='hourPicker']"));//input[@id='EndDateTime_time']
		System.out.println("after endtime");
		waitUntilVisible(endTime);
		//otherText=other.getText();
		System.out.println("in the end time textbox");
		 clickElement(endTime);

		//WebElement timelist= driver.findElement(By.xpath("//tbody/tr[1]/td[1]/select[1]"));//select[@id='p4']
		//waitUntilVisible(timelist);
		 Select selQReport3=new Select(endTime);
		 System.out.println("selected time is not working");
			selQReport3.selectByVisibleText(time);
			String ninepmselected=selQReport3.getFirstSelectedOption().getText();
		
		List	<WebElement> listEndTimeavailable= driver.findElements(By.xpath("//div[@class='hourPicker']"));
		//List <String> timeframe= new List();
		for(WebElement we:listEndTimeavailable)
		{ if(we.getText().equalsIgnoreCase("11:30 PM"))
			timeIsCorrect= true;
		
		else 
			timeIsCorrect= false;
		break;			 			   
		}
		
	}
	public void checkRecurrance()
	{
		
		waitUntilVisible(endTime);
		
		System.out.println("in the end time textbox");
		

		Select selQReport3=new Select(endTime);
		List	<WebElement> listEndTimeavailable= selQReport3.getOptions();
		//List <String> timeframe= new List();
		for(WebElement we:listEndTimeavailable)
		{ if(we.getText().equalsIgnoreCase("7:00 PM"))
			report.	logTestInfo("time selected endtime is 7pm");	 		   
		break;			 			   
		}
		
	
		recurring.click();
		if(recurring.isSelected()==true)
			
		report.	logTestInfo("recurring is selected");
		if(frequency.getText()=="Frequency")
			report.	logTestInfo("frequency is selected");
		if((startDate.getText().contains("Start"))&&(endDate.getText().contains("End")))
			
		weeklyRadioBtn.click();
		if(weeklyRadioBtn.isSelected())
			report.	logTestInfo("radioBtn is selected");
		
		
		String recurValue=	 RecurEvery.getAttribute("value");
		if(recurValue=="1")
			report.	logTestInfo("recuevalue is 1");;
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date dt = new java.sql.Date(utilDate.getTime());
		System.out.println("Today's date: "+dt);
		java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
		cal.setTime(dt);
		// Getting the day of the week
		//cal.get(java.util.Calendar.DAY_OF_WEEK)
		System.out.println("Day of the week: "+cal.get(java.util.Calendar.DAY_OF_WEEK));
		// calender.get(Calender.)
		
		for(WebElement we:checkboxCurrentDay)
		{ if(we.isSelected())
		{
			if( (we.getAttribute("value")).equalsIgnoreCase(String.valueOf(cal.get(java.util.Calendar.DAY_OF_WEEK))))
			{
				report.	logTestInfo("checkbox value pf the day is selected");;			 		   
				break;	}	
		}
		int noOfDays = 14; //i.e two weeks
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);

		//add 2 week to the current date
		LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);
		Format f = new SimpleDateFormat("MM/dd/yy");
		String strDate = f.format(next2Week);
		System.out.println("Next week: " + strDate);
		
		endDatecalender.sendKeys(strDate);

		System.out.println("Next week: " + next2Week);
	}
	}
	public boolean saveTheNewEventPage(String string1,String string2)
	{
		waitUntilVisible(saveBtn);
		clickElement(saveBtn);
		 
		waitUntilVisible(calenderForFNLNameme);
		String calenderSaveText=calenderForFNLNameme.getText();
		if(calenderText.equalsIgnoreCase("Calendar for c Chh"));
		
		
		Actions act= new Actions(driver);
		//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[5]/td[2]
		act.moveToElement(otherLink).perform();
		//WebElement startTime= driver.findElement(By.xpath("(//td[@class='labelCol'])[5]"));
		//WebElement EndTime= driver.findElement(By.xpath("//td[@class='dataCol last']"));

		if((startTime.getText().contains(string1))&&(endTime1.getText().contains(string2)))
			return true;
		else return false;

	}
		



}
