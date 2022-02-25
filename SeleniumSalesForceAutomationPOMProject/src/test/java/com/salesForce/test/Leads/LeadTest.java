package com.salesForce.test.Leads;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.test.Base.BaseTest;

public class LeadTest extends BaseTest
{
	@Test

	public void LeadsHomT20() 
	{
		 loginPage.verifyCredentilas();
			boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
			Assert.assertTrue(leadsHome.LeadpageVerification());
	}
	@Test
	public void T21LeadSelectView()
	{
		 loginPage.verifyCredentilas();
			boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
			Assert.assertTrue(leadsHome.LeadpageVerification());
			boolean leadDropMenu=	leadsHome.leadDropDownMenuverification();
			Assert.assertTrue(leadDropMenu);
			
	}
	@Test
	public void T22DefaultView()
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		//leadsHome.LeadpageVerification();
		Assert.assertEquals(leadsHome.LeadpageVerification(),true, "lead page verification pass");
		leadsHome.TodaysLeadLogOut();
		loginPage.verifyCredentilas();
		boolean userNTitleMatch1= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		Assert.assertEquals(true, userNTitleMatch1, "home page verification pass");
		Assert.assertEquals(leadsHome.LeadpageVerification(),true, "lead page verification pass");
		//boolean todaylead=leadsHome.ReLoginSelectionAndGoBtnClick();
		
		Assert.assertTrue(leadsHome.ReLoginSelectionAndGoBtnClick());
	
	}  
	@Test
	public void T23TodaysLead() 
	{
		loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();
		Assert.assertEquals(true, userNTitleMatch, "home page verification pass");
		Assert.assertEquals(true, leadsHome.LeadpageVerification(), "lead page verification pass");
		Assert.assertTrue(leadsHome.todayLeadSelection());
	}
	@Test
	public void T24NewLead() 
	{
		 loginPage.verifyCredentilas();
			boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
			Assert.assertEquals(true, leadsHome.LeadpageVerification(), "lead page verification pass");
			Assert.assertEquals(true, leadsView.newLeadPage(), "new lead page verification pass");
			Assert.assertEquals(true, leadsView.NewLeadSaved(), "new createdlead saved and page verified");
		
	}
}
