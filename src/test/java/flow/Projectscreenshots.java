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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;




public class Projectscreenshots  {
	
	WebDriver driver;

	public Projectscreenshots(WebDriver driver ){
		this.driver=driver;
		
	}
	public XWPFDocument document=new XWPFDocument(); 
	
// to change the document orientation into landscape
	private static void setLandscapeOrientation(XWPFDocument document) {
		
// Access the document's section properties
        CTPageSz pageSize = document.getDocument().getBody().addNewSectPr().addNewPgSz();

// Set the width and height for landscape orientation (in twentieths of a point)
        pageSize.setW(16840); // 11 inches
        pageSize.setH(11900); // 8.5 inches
        
// Mark orientation as landscape
        pageSize.setOrient(STPageOrientation.LANDSCAPE);
    }

//Screenshots only Page

    public void screenShots(String testCaseName) throws Exception {                                               // Take a screenshot
		
		WebDriver driver = null;  
		
//To take a screenshot   
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
//to change the orientation into landscape
		setLandscapeOrientation(document);
		
//To write a test case name       	 
        XWPFParagraph paragraph = document.createParagraph();
	     XWPFRun run = paragraph.createRun();
	     run.setText(testCaseName);
	     run.addBreak();
	       
// Add screenshot to Word document
		FileInputStream screenshotInputStream = new FileInputStream(screenshot);
        run.addPicture(screenshotInputStream,  XWPFDocument.PICTURE_TYPE_PNG, 
                       "screenshot.png", Units.toEMU(800), Units.toEMU(300));
     }
		           
	

		//Screenshot Along with URL   
		           public void screenShotURL(String testCaseName, String screenShotPath) throws AWTException, IOException, InvalidFormatException {
		        	   //to take screenshot along with the URl
		        	  
		        	   Robot robot=new Robot();
		      Rectangle screenRect=new Rectangle( Toolkit.getDefaultToolkit().getScreenSize());
		      BufferedImage bufferImage=robot.createScreenCapture(screenRect);
		     // String screenShotPath=System.getProperty("user.dir")+"//Stability//robot.png";
		     ImageIO.write(bufferImage, "png", new File(screenShotPath));
		      
		     //to change the orientation into landscape
		      setLandscapeOrientation(document);
		      //To write a test case name  
		      document.createParagraph().createRun().setText(testCaseName);
		      
		     
	   

			     // Add screenshot to Word document
		      FileInputStream inputStream = new FileInputStream(new File(screenShotPath));
	           
		      document.createParagraph().createRun().addPicture(
                      inputStream,
                      XWPFDocument.PICTURE_TYPE_PNG,
                      screenShotPath,
                      Units.toEMU(700), // Image width (adjust as needed)
                      Units.toEMU(400)  // Image height (adjust as needed)
                  );
		        	   
		      
		      
		      
		           }



		
	}
