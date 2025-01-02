package stabilityFlow;


import org.testng.annotations.*;



public class Loginpage extends ManiflowLogin {
	
	@Test(priority=3)
	public void Step4_1_3() {
		try{
	
		loginpage_l_a.profileClick();
		Thread.sleep(2000); 
		projectScreenshots.screenShotURL("Screenshot No. : 01   for Step No. 4.1.3", reportPath);
		
		}catch (Exception e) {
            e.printStackTrace();
		}
		validations.validateStep4_1_3();
	}
	@Test(priority=4, dependsOnMethods= {"Step4_1_3"})
	public void Step4_1_4() {
		try{
			loginpage_l_a.userProfileClick();
		
			Thread.sleep(2000); 
			projectScreenshots.screenShotURL("Screenshot No. : 01   for Step No. 4.1.4", reportPath);
			}catch (Exception e) {
	            e.printStackTrace();
			}
		}
	@Test(priority=5, dependsOnMethods= {"Step4_1_3"})
	public void Step4_1_5() {
		try{
			loginpage_l_a.logoutButton();
		
			Thread.sleep(2000); 
			projectScreenshots.screenShotURL("Screenshot No. : 01   for Step No. 4.1.4", reportPath);
			}catch (Exception e) {
	            e.printStackTrace();
			}
		}

	
}
