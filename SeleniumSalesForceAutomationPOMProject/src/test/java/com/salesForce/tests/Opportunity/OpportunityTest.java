package com.salesForce.tests.Opportunity;

import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.test.Base.BaseTest;

public class OpportunityTest extends BaseTest{
	
	@Test
 public void opportunityUserT15()
 {
	    loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
	    Boolean isOporPage=opportunty.oprtunityPageAndUserNameVerification();
	    Assert.assertTrue(isOporPage);
	    Boolean isDropdwnMenu= opportunty.OPortunityDropDownMenuverification();
 }
 @Test
 public void createNewOportuntyT16()
 { loginPage.verifyCredentilas();
	boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
    Boolean isOporPage=opportunty.oprtunityPageAndUserNameVerification();
    Assert.assertTrue(isOporPage);
    Assert.assertTrue(newOpportunity.createNewOptunty());
	 
 }
 @Test
	 public void opportunityPipeLineUserT17()
	 {
		    loginPage.verifyCredentilas();
			boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
		    Boolean isOporPage=opportunty.oprtunityPageAndUserNameVerification();
		    Assert.assertTrue(isOporPage);
		    report.logTestInfo("opportunitypageVerified");
		    Assert.assertTrue(oportunityPipeline.reportGenerate());
		    report.logTestInfo("opportunity report Generated");
		    
	 }
	 @Test
 public void stuckOpportunityT18()
 {
	    loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
	    Boolean isOporPage=opportunty.oprtunityPageAndUserNameVerification();
	    Assert.assertTrue(isOporPage);
	    report.logTestInfo("opportunitypageVerified");
	    Assert.assertTrue(stuckOportunities.reportGenerate(),"stuck op report ");
	    report.logTestInfo("stuckoptunity report Generated");
	    
 }
 @Test
 public void QuartelySumryReportT18()
 {
	    loginPage.verifyCredentilas();
		boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();	
	    Boolean isOporPage=opportunty.oprtunityPageAndUserNameVerification();
	    Assert.assertTrue(isOporPage);
	    report.logTestInfo("opportunitypageVerified");
	    Assert.assertTrue(oportunityReport.quarterlySummrtReportT19());
	    report.logTestInfo("quartly report Generated");
	    
 }
}
