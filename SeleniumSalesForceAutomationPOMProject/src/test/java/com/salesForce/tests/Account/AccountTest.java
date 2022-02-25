package com.salesForce.tests.Account;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.test.Base.BaseTest;
import com.salesForce.utility.CommmonUtilities;
import com.salesfForce.pages.Accounts.AccountNew;

public class AccountTest extends BaseTest{
 //@Test
	public void createAccountT10()
	{
	    loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		accounts.accountTabClick();
		report.logTestInfo("accountPageVerification"+accounts.PageAndUserNameVerification());
		Assert.assertTrue(accounts.PageAndUserNameVerification());
		boolean isNewAccCreated=accountNew.createNewAccount();
		Assert.assertTrue(isNewAccCreated);
		
	}
// @Test
 public void createNewViewT11()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		accounts.accountTabClick();
		report.logTestInfo("accountPageVerification"+accounts.PageAndUserNameVerification());
		Assert.assertTrue(accounts.PageAndUserNameVerification());
		boolean isNewViewCreated=accountNewView.createNewView();
		Assert.assertTrue(isNewViewCreated);
	}
 //@Test
 public void editViewT12()
 {
	 loginPage.verifyCredentilas();
	boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
	Assert.assertTrue(userNTitleMatch);
	accounts.accountTabClick();
	report.logTestInfo("accountPageVerification"+accounts.PageAndUserNameVerification());
	Assert.assertTrue(accounts.PageAndUserNameVerification());
	boolean isviewAndEditpage=accountEdit.selectViewandEditAccount();
	Assert.assertTrue(isviewAndEditpage);
	Assert.assertTrue(accountEdit.selectViewandEditAccount());	
	Assert.assertTrue(accountEdit.EditTheView());
 }
 @Test
 public void mergeAccountT13()
 {
	 loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		accounts.accountTabClick();
		report.logTestInfo("accountPageVerification"+accounts.PageAndUserNameVerification());
		Assert.assertTrue(accountMerge.mergeAccount());
 }
 //@Test
 public void createAccountReportT14()
 {
	 loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertTrue(userNTitleMatch);
		accounts.accountTabClick();
		report.logTestInfo("accountPageVerification"+accounts.PageAndUserNameVerification());
		//Assert.assertTrue(accountMerge.mergeAccount());
		Assert.assertTrue(accountReport.createAccountReport());
		Assert.assertTrue(accountReport.selectReportOption());
 }
}
