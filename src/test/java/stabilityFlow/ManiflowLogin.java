package stabilityFlow;

import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Listeners;

import org.testng.annotations.*;

import Locators_Actions.Department_l_a;
import Locators_Actions.Loginpage_l_a;
import flow.Projectscreenshots;
import flow.validationsLoginPage;
@Listeners(flow.ExtentReportManager.class)
public class ManiflowLogin  {
	
	
	WebDriver driver;
	
	
	Projectscreenshots projectScreenshots = new Projectscreenshots(driver);
	String reportPath="Stability/TestCase2Report.docx";
	
	
	Loginpage_l_a loginpage_l_a;
	validationsLoginPage validations;
	Department_l_a department_l_a;
	@BeforeTest
	public void browserLogin() {
		
		driver= new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void lp() {
		loginpage_l_a=new Loginpage_l_a(driver);
		validations =new validationsLoginPage(driver);
		department_l_a=new Department_l_a(driver);
	}
	
	@Test(priority=1)
	public void Step4_1_1() {
		try{
		driver.get("http://localhost:8080/login");
	   Thread.sleep(1000); 
		projectScreenshots.screenShotURL("Screenshot No. : 01   for Step No. 4.1.1", reportPath);
		}
		catch (Exception e) {
            e.printStackTrace();
		}
		validations.validateStep4_1_1();
		
	}
	@Test(priority=2)
	public void Step4_1_2() {
		try {
		loginpage_l_a.loginDetails("admin","admin");
		Thread.sleep(1000); 
		projectScreenshots.screenShotURL("Screenshot No. : 01   for Step No. 4.1.2", reportPath);
		loginpage_l_a.loginButton();
		Thread.sleep(2000); 
	    projectScreenshots.screenShotURL("Screenshot No. : 01   for Step No. 4.1.2", reportPath);

		}
		catch (Exception e) {
            e.printStackTrace();
		}
		validations.validateStep4_1_2();
	}
	 @AfterClass
	    public void tearDown() throws IOException {
		 
	        // Save the Word document
	        try (FileOutputStream out = new FileOutputStream(reportPath)) {
	        	projectScreenshots. document.write(out);
	        	out.close();
	            System.out.println("Word document created successfully at " + reportPath);
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	            
	    
	        projectScreenshots. document.close();
	    }

	
	
}
