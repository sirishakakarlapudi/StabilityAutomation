package stabilityFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Locators_Actions.Department_l_a;
public class Department extends ManiflowLogin {
	
	@Test(priority=3)
	public	void Step4_2_3() {
		department_l_a.departmentClick();
		System.out.println(department_l_a.departmentSubModuleListactualDisplay());
		
	}
}
