package com.salesForce.tests.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.test.Base.BaseTest;
import com.salesForce.utility.CommmonUtilities;

public class LoginTest extends BaseTest{
	
	
    @Test
	public void LoginwithoutPwdT1() {
		System.out.println("entering to logintest @test");
		String username=CommmonUtilities.getApplicationProperty("username");
		loginPage.enterIntoUsername(username);
		loginPage.enterIntoPassword("");
		loginPage.clcikLoginButton();
		String errorTxt=loginPage.getErrorMessage();
		report.logTestInfo("errorMsg received"+errorTxt);
		Assert.assertEquals(errorTxt,"Please enter your password.");
		
		
	}
	@Test
	public void LoginToSFDCT2() {
		String username=CommmonUtilities.getApplicationProperty("username");
		loginPage.enterIntoUsername(username);
		String password=CommmonUtilities.getApplicationProperty("password");
		loginPage.enterIntoPassword(password);
		loginPage.clcikLoginButton();
		boolean userandHomeVerigy=homePage.verifyTitleOfTheHomePageAndUserAccount();
		Assert.assertTrue(userandHomeVerigy);
		//homePage
	}
	@Test
	public void checkRemeberMe3() {
		String username=CommmonUtilities.getApplicationProperty("username");
		loginPage.enterIntoUsername(username);
		String password=CommmonUtilities.getApplicationProperty("password");
		loginPage.enterIntoPassword(password);
		loginPage.clcikCheckBox();
		loginPage.clcikLoginButton();
		boolean userandHomeVerigy=homePage.verifyTitleOfTheHomePageAndUserAccount();
		Assert.assertTrue(userandHomeVerigy);
		homePage.clcikloginlink();
		report.logTestInfo("loginLink Clicked In homePage");
		homePage.clcikLogoutlink();
		report.logTestInfo("logOutLink Clicked In homePage");
		String userTextAfterLogoutCheckBo=loginPage.gettextBoxDateAfterLogOut();
		report.logTestInfo("got the textboxusername"+userTextAfterLogoutCheckBo);
		Assert.assertEquals(userTextAfterLogoutCheckBo,username);
		
	}
	@Test
	public void validateLoginErrorMesg4B() {
		System.out.println("entering to logintest @test");
		//String username=CommmonUtilities.getApplicationProperty("username");
		
		loginPage.enterIntoUsername("hghghg");
		loginPage.enterIntoPassword("123");
		loginPage.clcikLoginButton();
		String errorTxt=loginPage.getErrorMessage();
		report.logTestInfo("errorMsg received"+errorTxt);
		Assert.assertEquals(errorTxt,"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		
		
	}
	@Test
	public void ForgotPassword4A()
	{
		String username=CommmonUtilities.getApplicationProperty("username");
		loginPage.enterIntoUsername(username);
		loginPage.clcikForgotPwd();
		loginPage.sendTextEmail();
		Assert.assertTrue(loginPage.messageforForgotPwd(),"passwordReset linksent"); 
	}
	

}

/*
 * driver.get(CommmonUtilities.getApplicationProperty("url"));
		String username=CommmonUtilities.getApplicationProperty("username");
		String password=CommmonUtilities.getApplicationProperty("password");
		login(username,password);
		System.out.println("end of before method");
 */

