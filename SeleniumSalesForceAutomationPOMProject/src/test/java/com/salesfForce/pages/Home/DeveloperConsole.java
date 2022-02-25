package com.salesfForce.pages.Home;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesForce.base.BasePage;

public class DeveloperConsole extends BasePage {
	public DeveloperConsole(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//span[@id='userNavLabel']") WebElement userMenu;
	@FindBy(xpath ="//a[@title='Developer Console (New Window)']") WebElement developerConsole;
	
	public boolean clickConsole()
	{
		
		clickElement(userMenu);
		clickElement(developerConsole);
		String wintitle="";
		String currentWindow= driver.getWindowHandle();
		 Set<String> windows =driver.getWindowHandles();

		 System.out.println(windows.size());
		for( String windo1:windows)
		 {
			 if(!windo1.equals(currentWindow))
			 {
				 driver.switchTo().window(windo1);
				 wintitle= driver.getTitle();
				 System.out.println(wintitle);
				 
				 driver.switchTo().window(currentWindow);
				break;
			 }
		 }
		if(wintitle.contains("Developer"))
			return true;
		else 
			return false;
		}
			
		
	}



