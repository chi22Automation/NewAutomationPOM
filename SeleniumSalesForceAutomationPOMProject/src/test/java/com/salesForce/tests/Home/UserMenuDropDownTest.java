package com.salesForce.tests.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.test.Base.BaseTest;
import com.salesForce.utility.CommmonUtilities;

public class UserMenuDropDownTest extends BaseTest {
	@Test
	public static void userMenuVerification()
	{ 
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		boolean userMenuMatch=homePage.clickuserMenuData();	
		Assert.assertTrue(userMenuMatch);
		report.logTestInfo("userMenuMatched received"+userMenuMatch);
		homePage.mouseOverelement();
		report.logTestInfo("mouseoverLoginLink");	
		homePage.clickprofileLink();
		report.logTestInfo("before clicking editProfile on profile page");
		String newchangeName="abcd";
		//String changelastname=profilePage.ProfilEdit(newchangeName);
		report.logTestInfo("before Assert");
		//Assert.assertEquals(("c"+" "+newchangeName), (changelastname));
		profilePage.clickpostink();
		report.logTestInfo("After Test methodClickpostlink");
		//profilePage.clickFileLink();
		report.logTestInfo("After Test method clickFileLink");
		profilePage.clickuploadphotolink();
		report.logTestInfo("After Test method clickuploadphotolink");

	}
	@Test
	
	public static void userDropdownMysettingsT07()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		report.logTestInfo("userMenuMatched received"+userNTitleMatch);
		homePage.clickpmysettingLink();
		report.logTestInfo("clickpmysettingLink");
		Assert.assertTrue(mySettingPage.checkTitleofSetting());
		report.logTestInfo("my setting title assertted");
		Assert.assertTrue(mySettingPage.downloadLoginHistory(),"downloaded history");
		Assert.assertTrue(mySettingPage.displayAndlayOut(),"displayandlayout");
		Assert.assertTrue(mySettingPage.emailNameAndEmailSet(),"emailNameandMail");
		Assert.assertTrue(mySettingPage.calenderAndEvent(),"calender event");
		
		
	}
	@Test
	public static void developerCOnsoleT08()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		boolean userMenuMatch=homePage.clickuserMenuData();	
		Assert.assertTrue(userMenuMatch);
		report.logTestInfo("userMenuMatched received"+userMenuMatch);
		Assert.assertTrue(developerConsole.clickConsole());
	}
  @Test
	public static void  userDropLogOut()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		boolean userMenuMatch=homePage.clickuserMenuData();	
		Assert.assertTrue(userMenuMatch);
		report.logTestInfo("userMenuMatched received"+userMenuMatch);
		homePage.clcikLogoutlink();
		String afterlogoutTitle=driver.getCurrentUrl();
		report.logTestInfo(afterlogoutTitle);
	}


}