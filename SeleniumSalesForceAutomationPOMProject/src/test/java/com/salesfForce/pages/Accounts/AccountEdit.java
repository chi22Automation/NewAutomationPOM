package com.salesfForce.pages.Accounts;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesForce.base.BasePage;


public class AccountEdit extends BasePage{

	public AccountEdit(WebDriver driver1) {
		super(driver1);
	}
	String userValue="";
	String selectedvaluetocompare="";
	@FindBy(xpath ="//select[@title='View:']") WebElement accountviewTab;
	@FindBy(xpath ="//a[text()='Edit']") WebElement edit;
	@FindBy(xpath ="//input[@id='fname']") WebElement userValueToEdit;
	@FindBy(id ="tryLexDialogX") WebElement lightDialogue;
	
	@FindBy(xpath ="userValueToEdit") WebElement saveNewView;
	@FindBy(id ="fcol1") WebElement accountWeb;
	@FindBy(xpath ="//select[@title='Operator 1']") WebElement operator;
	@FindBy(xpath ="//select[@id='colselector_select_1']") WebElement availableTab;
	@FindBy(xpath ="//select[@name='colselector_select_0']") WebElement displayTab;
	@FindBy(xpath ="//a[@id='colselector_select_0_right']") WebElement addBtn;
	@FindBy(xpath ="//input[@data-uidsfdc='5']") WebElement saveBtn;
	@FindBy(xpath ="//select[@title='View:']") WebElement accountnewViewToVerify;
	@FindBy(xpath ="//input[@title='Value 1']") WebElement value;
	public boolean selectViewandEditAccount()
	{
		boolean editView=false;
		Select accountviewTab1 = new Select(accountviewTab);
		WebElement selectedvalue= accountviewTab1.getFirstSelectedOption();
		System.out.println(selectedvalue.getText()); 
	    selectedvaluetocompare=selectedvalue.getText();
		accountviewTab1.selectByVisibleText(selectedvalue.getText());
		waitUntilDisplayed(edit);
		clickElement(edit);
		//accountviewTab1.selectByVisibleText(selectedvalue.getText());
		String editTitle=driver.getTitle();
		String userValue=userValueToEdit.getAttribute("value");
		System.out.println(userValue);
		if((editTitle.equalsIgnoreCase("Accounts: Edit View ~ Salesforce - Developer Edition")) && (userValue.equalsIgnoreCase(selectedvaluetocompare)))
			editView= true;
		else
			editView=false;
		return editView;
	}
	public boolean EditTheView()
	{ boolean isEditView=false;
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		String uniqueName= userValue+(rand.nextInt(upperbound));
		userValueToEdit.sendKeys(uniqueName);
		waitUntilVisible(accountWeb);

		Select selectAccount = new Select(accountWeb);
		System.out.println("accountWeb");
		selectAccount.selectByValue("Account Name");
		Select selectOperator = new Select(operator);
		selectOperator.selectByValue("contains");
		value.sendKeys("a");

		Select availableTab1 = new Select(availableTab);
		List <WebElement> op = availableTab1.getOptions();
		System.out.println( op.get(5).getText());
		int size = op.size();
		for(int i =0; i<size ; i++){
			if(op.get(i).getText().equalsIgnoreCase("Last Activity"))
			{
				break;


			}
			else
			{ Select displayTab1 = new Select(displayTab);
			displayTab1.selectByVisibleText("Last Activity");
			clickElement(addBtn);
			clickElement(saveBtn);
			Select accountviewTabnew = new Select(accountnewViewToVerify);
			String nwelyaddedViw= accountviewTabnew.getFirstSelectedOption().getAttribute("text");
			if (nwelyaddedViw.equalsIgnoreCase(uniqueName))
				isEditView= true;
			else
				isEditView=false;
			}
		}
		return isEditView;
	}
}
		
		