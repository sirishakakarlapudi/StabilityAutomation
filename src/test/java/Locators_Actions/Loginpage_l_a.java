package Locators_Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Loginpage_l_a {

	private  WebDriver driver;
	
	
public Loginpage_l_a(WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);
		
	}
	
	
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath="//b[normalize-space()='STABILITY MANAGEMENT APPLICATION']")
	WebElement applicationName;
	@FindBy(id="username")
	WebElement txt_username;
	@FindBy(id="password")
	WebElement txt_password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	@FindBy(xpath="//i[normalize-space()='Stability']")
	WebElement appName;
	@FindBy(xpath="//ul[@id='accordion']/li")
	List<WebElement> moduleList;
	@FindBy(xpath="//div[@id='more-details']")
	WebElement profileName;
	@FindBy(xpath="//div[@class='collapse show']")
	WebElement profileCollapse;
    @FindBy(xpath="//h5[normalize-space()='Profile']")
    WebElement profileHeading;
	@FindBy(xpath="//ul[@class='list-unstyled']/li")
	List<WebElement> profileList;
	@FindBy(xpath="//ul[@class='list-unstyled']/li[1]/a")
	WebElement userProfile;
	@FindBy(xpath="//div[@class='card mb-4']//div[@class='row']")
	List<WebElement> userProfileDataList;
	@FindBy(xpath="//ul[@class='list-unstyled']/li[3]/a")
	WebElement logout;
	
	
	
	public WebElement applicationName() {
		wait1.until(ExpectedConditions.visibilityOf(applicationName));
		return applicationName;
	}
	
	public void loginDetails(String username, String password) {
		
		wait1.until(ExpectedConditions.visibilityOf(txt_username)).sendKeys(username);

		wait1.until(ExpectedConditions.visibilityOf(txt_password)).sendKeys(password);
		
	}
	
	public void loginButton() {
		wait1.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
	}
	
	
	public WebElement appName() {
		wait1.until(ExpectedConditions.visibilityOf(appName));
		return appName;
	}
	
	
	public List<String> moduleListActualDisplay() {
		List<String> actualModuleList = new ArrayList<>();
		for(WebElement moduleElement: moduleList) {
			actualModuleList.add(moduleElement.getText());
			
		}
		return actualModuleList;
		}
	
	
	public List<String> moduleListExpectedDisplay() {
			List<String> expectedModulelist=Arrays.asList("Dashboard","User Management","Departments","User Groups","Facilities","Stability Condition","Equipment","Product Master","Stability Programme","Force Close","Stability Trend Results","Reports","Audit Trails");
			return expectedModulelist;
	}
	
		
	public void profileClick() {
			wait1.until(ExpectedConditions.elementToBeClickable(profileName)).click();
		}
	
	public WebElement profileHeading() {
			wait1.until(ExpectedConditions.visibilityOf(profileHeading));
			return profileHeading;
		}
		public WebElement profileCollapse() {
			wait1.until(ExpectedConditions.visibilityOf(profileCollapse));
			return appName;
		}
		
		public List<String> profileListActualDisplay() {
			List<String> actualProfileList = new ArrayList<>();
			for(WebElement profileElement: profileList) {
				actualProfileList.add(profileElement.getText());
				
			}
			return actualProfileList;
			}
			public List<String> profileListExpectedDisplay() {
				List<String> expectedProfilelist=Arrays.asList("Profile","Password","Logout");
				return expectedProfilelist;
		}
			
			public void userProfileClick() {
				wait1.until(ExpectedConditions.elementToBeClickable(userProfile)).click();
			}
			
			
			public List<String> userProfileDataListActualDisplay() {
				List<String> actualUserProfileDataList = new ArrayList<>();
				for(WebElement userProfileElement: userProfileDataList) {
	                     String userProfileString= userProfileElement.getText();
	                     String userProfileSpiltString=userProfileString.split(" :")[0];
					actualUserProfileDataList.add(userProfileSpiltString);
					
				}
				return actualUserProfileDataList;
				}
				public List<String> userProfileDataListExpectedDisplay() {
					List<String> expectedUserProfileDatalist=Arrays.asList("Employee Id", "Full Name", "Email", "Department Name", "User Role", "Designation");
					return expectedUserProfileDatalist;
			}
				public void logoutButton() {
					wait1.until(ExpectedConditions.elementToBeClickable(logout)).click();
				}		
}
