package com.salesfForce.pages.Accounts;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.salesForce.base.BasePage;
public class AccountNewView extends BasePage{

	public AccountNewView(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//div[@class='filterOverview']//a[2]") WebElement newView;
	@FindBy(xpath ="//tbody/tr[1]/td[2]/div[1]/input[1]") WebElement viewName;
	@FindBy(xpath ="//tbody/tr[2]/td[2]/div[1]/input[1]") WebElement uniqueName;
	@FindBy(xpath ="//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")  WebElement  saveBtn;
	@FindBy(xpath ="//select[@title='View:']")  WebElement  creatednewview;
	
	//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]
	
	 public boolean createNewView()
	 {
		 waitUntilVisible(newView);
		 clickElement(newView);
		 Random rand = new Random(); //instance of random class
			int upperbound = 25;
			//generate random values from 0-24
			int int_random = rand.nextInt(upperbound);
			String name="geet"+(rand.nextInt(upperbound));
			viewName.sendKeys(name);
			uniqueName.sendKeys(name+"_1");
			waitUntilDisplayed(saveBtn);
			clickElement(saveBtn);	
			Select accountviewTab = new Select(creatednewview);//select[@title='View:']
			System.out.println("view after saved in selected drop box"); 
			WebElement selectedvalue= accountviewTab.getFirstSelectedOption();
			System.out.println("selected value is"+selectedvalue.getText()); 
			String selectedvaluetocompare=selectedvalue.getText();
			String text= creatednewview.getText();
			if(name.equalsIgnoreCase(selectedvaluetocompare))
				return true;
			else
				return false;
		 
	 }
}
