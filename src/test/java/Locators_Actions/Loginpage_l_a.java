package Locators_Actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage_l_a {

	WebDriver driver;
	WebDriverWait wait;
	
	public Loginpage_l_a(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(id="username")
	WebElement txt_username;
	@FindBy(id="password")
	WebElement txt_password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	public void loginDetails(String username, String password ) {
		wait.until(ExpectedConditions.visibilityOf(txt_username)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(txt_password)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
	}
}
