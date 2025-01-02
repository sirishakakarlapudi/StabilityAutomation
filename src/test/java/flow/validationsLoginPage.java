package flow;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Locators_Actions.Loginpage_l_a;

public class validationsLoginPage {
	WebDriver driver;
	Loginpage_l_a loginpage_l_a= new Loginpage_l_a(driver);
	
	public validationsLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	 public void validateStep4_1_1() {
		 Loginpage_l_a loginpage_l_a= new Loginpage_l_a(driver);
		 String expUrl="http://localhost:8080/login";
		 String actUrl=driver.getCurrentUrl();
		 Assert.assertEquals(expUrl, actUrl);
		 boolean applicationNamevalidate=loginpage_l_a.applicationName().isDisplayed();
			if(applicationNamevalidate==true)
			{
			Assert.assertTrue(true);
				}
			else
			 {
					Assert.fail();
				}	
	 }
	
	 public void validateStep4_1_2() {
		 Loginpage_l_a loginpage_l_a= new Loginpage_l_a(driver);
	    List<String> actualModulelist=loginpage_l_a.moduleListActualDisplay();
		List<String> expectedModulelist=loginpage_l_a.moduleListExpectedDisplay();
		   Assert.assertEquals(actualModulelist,expectedModulelist);
			boolean appNamevalidate=loginpage_l_a.appName().isDisplayed();
			if(appNamevalidate==true)
			{
			Assert.assertTrue(true);
				}
			else
			 {
					Assert.fail();
				}
			
	 }
	 public void validateStep4_1_3() {
		 Loginpage_l_a loginpage_l_a= new Loginpage_l_a(driver);
		 List<String> actualProfilelist=loginpage_l_a.profileListActualDisplay();
		 List<String> expectedProfilelist=loginpage_l_a.profileListExpectedDisplay();
		 Assert.assertEquals(actualProfilelist,expectedProfilelist);
		 boolean profileheadingvalidate=loginpage_l_a.profileCollapse().isDisplayed();
			if(profileheadingvalidate==true)
			{
			Assert.assertTrue(true);
				}
			else
			 {
					Assert.fail();
				}
	 }
	 
	 public void validateStep4_1_4() {
		 Loginpage_l_a loginpage_l_a= new Loginpage_l_a(driver);
		 List<String> actualUserProfilelist=loginpage_l_a.userProfileDataListActualDisplay();
		 List<String> expectedUserProfilelist=loginpage_l_a.userProfileDataListExpectedDisplay();
		 Assert.assertEquals(actualUserProfilelist,expectedUserProfilelist);
		 boolean profileheadingvalidate=loginpage_l_a.profileHeading().isDisplayed();
			if(profileheadingvalidate==true)
			{
			Assert.assertTrue(true);
				}
			else
			 {
					Assert.fail();
				}
	 }
	 
}
