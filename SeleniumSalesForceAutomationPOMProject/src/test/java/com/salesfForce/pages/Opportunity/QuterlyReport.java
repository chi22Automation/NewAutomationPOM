package com.salesfForce.pages.Opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class QuterlyReport extends BasePage{

	public QuterlyReport(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//select[@id='quarter_q']") WebElement quReportEle;
	@FindBy(xpath="//select[@id='open']") WebElement typeOpp;
	@FindBy(xpath="//input[@value='Run Report']") WebElement runBtn;
	@FindBy(xpath="//select[@name='scope']") WebElement correctReport;
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']") WebElement reportHeader;
	//h1[@class='noSecondHeader pageType']

	public boolean quarterlySummrtReportT19()
	{ selectByTextData(quReportEle, "Current FQ");
	selectByTextData(typeOpp, "All Opportunities");
	report.logTestInfo(null);
	waitUntilVisible(runBtn);
	clickElement(runBtn);
	WebElement reportcorrectoption=selectByfirstvisibleDate(correctReport);
	if(reportHeader.getText().contains("Opportunity Report"))
		return true;
	else
		return false;

	}
	public WebElement selectByfirstvisibleDate(WebElement element)
	{
		Select selQReport2=new Select(element);
		WebElement reportcorrectoption= selQReport2.getFirstSelectedOption();
		return reportcorrectoption;


	}
}
