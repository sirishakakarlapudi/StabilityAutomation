package stabilityFlow;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import flow.Projectscreenshots;

public class Loginpage {
//WebDriver driver;
	//Readingproperitesfile propertyobj=new Readingproperitesfile();
	Projectscreenshots projectScreenshots = new Projectscreenshots();
	String reportPath="TestCasesReport.docx";
	
	@BeforeTest
	public void browserLogin() {
		
		projectScreenshots .	driver= new ChromeDriver();
		projectScreenshots . driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void TestCase4_1_1() {
		try{

		projectScreenshots .driver.get("http://localhost:8080/login");
		String expUrl="http://localhost:8081/login";
	   String actUrl=projectScreenshots .driver.getCurrentUrl();
	   Assert.assertEquals(expUrl, actUrl);
		Thread.sleep(2000);
		projectScreenshots.screenShotURL("Screenshot No. : 01   for Step No. 4.1.1");}
		catch (Exception e) {
            e.printStackTrace();
		}
		
		
	}
	@Test
	public void loginClick() {
		try{projectScreenshots.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		projectScreenshots.screenShotURL("Login Error");
		}catch (Exception e) {
            e.printStackTrace();
		}
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
	            
	        projectScreenshots. driver.quit();
	        projectScreenshots. document.close();
	    }

}
