package automation_challenge;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_test.Base_Test;
import webelement_repository.Home_Page;

@Listeners(listener.Listener_Implementation.class)
/*
 * Navigate to the home page In the test 3 div, 
 * assert that "Option 1" is the
 * default selected value Select "Option 3" from the select list
 */
/**
 * @author Vijay Ganesan
 */
public class Test_3 extends Base_Test {
	
	@Test
	public void test_3() throws InterruptedException
	{
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		//assert that "Option 1"  is defaultly selected
		Thread.sleep(2000);
		String text = home.getDropdown().getText();
		Assert.assertEquals(text.contains("Option 1"), true);
		Reporter.log("OPTION 1 IS SELECTED DEFAULTLY",true);
		//select option 3
		home.getDropdown().click();
		home.getAllOptions().get(2).click();
		Reporter.log("Option 3 selected",true);
	}
	

}
