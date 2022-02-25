package com.salesForce.test.Contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.test.Base.BaseTest;

public class ContactTest extends BaseTest
{
	@Test
	public  void createNewContactsT25()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
		Assert.assertTrue(contactHome.newContact(),"new contacted added");
		
	}
	@Test
	public  void T26createNewView()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
		Assert.assertTrue(contactNewView.createNewView(),"contact new view created");
	}
	@Test
	public  void T27CheckRecentlyAddesContacts()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
		Assert.assertTrue(contactHome.recentContact(),"recent contact viewed");
		
		
	}
	@Test
	public  void  T28CheckMyContactView()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
		Assert.assertTrue(contactHome.myContact(),"my contact viewed");
		
		
	}
	@Test
	public  void T29ViewContactPage()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
		Assert.assertTrue(contactHome.mycontactName(),"contactpage for clicked nale verified");
		
	}
	@Test
	public  void T30createNewViewErrorMessage()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
		Assert.assertTrue(contactNewView.errormessage(),"error message verified");
		
	}
	@Test
	public  void T31createNewViewCheckCancelButton()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
		Assert.assertTrue(contactNewView.cancelContact(),"contact cancel and home page appeard");
		
	}
	@Test
	public  void T32SaveAndNewButtonVerificationInNewContact()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
	Assert.assertTrue(contactHome.contactHomepage(),"contactHome page Verified");
	Assert.assertTrue(contactEdit.editAccount(),"account edit page verified");
	
	}

}
