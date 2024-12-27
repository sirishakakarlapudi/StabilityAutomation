package flow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;




public class Projectscreenshots  {
	public WebDriver driver;
public XWPFDocument document=new XWPFDocument();


//Screenshots only Page

		           public void screenShots(String testCaseName) throws Exception {                                               // Take a screenshot
		
	                                                                //To take a screenshot
		        	   
		        	   File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		               
		
		
		                                                        //To write a test case name
		
		 XWPFParagraph paragraph = document.createParagraph();
	     XWPFRun run = paragraph.createRun();
	     run.setText(testCaseName);
	     run.addBreak();
	    
	     
	     // Add screenshot to Word document
	     
	     
	     
		FileInputStream screenshotInputStream = new FileInputStream(screenshot);
        run.addPicture(screenshotInputStream, 
                            XWPFDocument.PICTURE_TYPE_PNG, 
                            "screenshot.png", 
                            Units.toEMU(500), Units.toEMU(300));
        
      

        
		           }
		           
		 //Screenshot Along with URL   
		           public void screenShotURL(String testCaseName) throws AWTException, IOException, InvalidFormatException {
		        	   //to take screenshot along with the URl
		        	   
		        	   Robot robot=new Robot();
		      Rectangle screenRect=new Rectangle( Toolkit.getDefaultToolkit().getScreenSize());
		      BufferedImage bufferImage=robot.createScreenCapture(screenRect);
		      String screenShotPath=System.getProperty("user.dir")+"//Stability//robot.png";
		      ImageIO.write(bufferImage, "png", new File(screenShotPath));
		      
		      
		      //To write a test case name  
		      document.createParagraph().createRun().setText(testCaseName);
		      
		     
	   

			     // Add screenshot to Word document
		      FileInputStream inputStream = new FileInputStream(new File(screenShotPath));
		      document.createParagraph().createRun().addPicture(
                      inputStream,
                      XWPFDocument.PICTURE_TYPE_PNG,
                      screenShotPath,
                      Units.toEMU(500), // Image width (adjust as needed)
                      Units.toEMU(300)  // Image height (adjust as needed)
                  );
		        	   
		      
		      
		      
		           }
		
	}
