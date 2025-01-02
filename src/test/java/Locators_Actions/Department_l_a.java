package Locators_Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Department_l_a {
	WebDriver driver;
	
	public Department_l_a(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));



@FindBy(xpath="//ul[@id='accordion']/li[3]")
WebElement department;
@FindBy(xpath="//ul[@id='accordion']/li[3]/a")
List<WebElement> departmentList;
@FindBy(xpath="//ul[@id='accordion']/li[3]/a[1]")
WebElement createDepartment;
@FindBy(xpath="//h5[normalize-space()='Create Department']")
WebElement createDepartmentHeading;
@FindBy(xpath="//input[@id='field_name']")
WebElement departmentName;
@FindBy(xpath="//input[@id='field_title']")
WebElement departmentTitle;
@FindBy(xpath="//input[@id='field_subtitle']")
WebElement departmentSubtitle;
@FindBy(xpath="//button[@id='save-entity']")
WebElement createButton;
@FindBy(xpath="//span[@class='ml-2']")
WebElement cancelbutton;
@FindBy(xpath="//h5[normalize-space()='Reason For Create']")
WebElement remarksPopupHeading;
@FindBy(xpath="//textarea[@formcontrolname='remarks']")
WebElement remarksInput;
@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
WebElement remarksPopupSubmit;
@FindBy(xpath="//button[@type='button']")
WebElement remarksPopupClose;
@FindBy(xpath="//h4[normalize-space()='Authenticate']")
WebElement authenticatePopupHeading;
@FindBy(xpath="//input[@formcontrolname='password']")
WebElement authenticatePassword;
@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement authenticatSubmit;


public void departmentClick() {
	department.click();
	
}
public List<String> departmentSubModuleListactualDisplay() {
	List<String> actualDepartmentSubModuleList = new ArrayList<>();
	for(WebElement submoduleElement: departmentList) {
		actualDepartmentSubModuleList.add(submoduleElement.getText());
		
	}
	return actualDepartmentSubModuleList;
	}
}
