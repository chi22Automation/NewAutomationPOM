package comm.fierbase.tests.RandomScenario;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.test.Base.BaseTest;

public class RandomScenarioTest extends BaseTest
{
	//@Test
	public  void verifyFirstAndLastNHomePageT33()
	{
		loginPage.verifyCredentilas();
	    boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();
	    boolean isFnLNprofileEqul=homePage.firstNlastPageHomePage();
	    System.out.println(isFnLNprofileEqul);
	   // Assert.assertTrue(homePage.firstNlastPageHomePage(),"fnLName and profilepage are same");
		
		
	}
	//@Test
	public static void verifyLastNEditedReflectedEveryWhereT34() 
	{
		loginPage.verifyCredentilas();
	    boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();
	    boolean isFnLNprofileEqul=homePage.firstNlastPageHomePage();
	    System.out.println(isFnLNprofileEqul);
	    String newchangeName="abcd";
		String changelastname=profilePage.ProfilEdit(newchangeName);
		
	}
	@Test
	public  void verifyTheTabCustomizaionT35()
	{
		loginPage.verifyCredentilas();
	    boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();
	    boolean isFnLNprofileEqul=homePage.firstNlastPageHomePage();
	    System.out.println(isFnLNprofileEqul);
	    userCustomisedPage.customizedMyTab();
	    homePage.selectFromCustomizedTabAndRemove();
	   
	   homePage.logOutNLoginFromCustom();
	    loginPage.verifyCredentilas();
	    assertTrue(homePage.relogin());
	    
		
	}
	
	//@Test
	public  void blockingAnEventIntheCalenderT36()
	{
		loginPage.verifyCredentilas();
	    boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();
	    boolean isFnLNprofileEqul=homePage.firstNlastPageHomePage();
	    System.out.println(isFnLNprofileEqul);
	    boolean isCurrentdatepage=calenderNewEvent.calanderCurrentDateLink();
		 System.out.println(isCurrentdatepage);
		calenderNewEvent.newEvent();
		calenderNewEvent.comboBoxClicked();
		calenderNewEvent.clickTheTime("9:00 PM");
		calenderNewEvent.saveTheNewEventPage("8:00 PM","9:00 PM");
	}
	//@Test
	public  void blockingAnEventIntheCalenderT37()
	{
		loginPage.verifyCredentilas();
	    boolean userNTitleMatch= homePage.verifyTitleOfTheHomePageAndUserAccount();
	    boolean isFnLNprofileEqul=homePage.firstNlastPageHomePage();
	    System.out.println(isFnLNprofileEqul);
	    boolean isCurrentdatepage=calenderNewEvent.calanderCurrentDateLink();
	    calenderNewEvent.newEvent4PM();
	    calenderNewEvent.comboBoxClicked();
	    calenderNewEvent.clickTheTime("5:00 PM");
	    calenderNewEvent.checkRecurrance();
	    calenderNewEvent.saveTheNewEventPage("8:00 PM","9:00 PM");
	}
	
}
