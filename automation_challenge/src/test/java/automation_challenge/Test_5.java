package automation_challenge;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_test.Base_Test;
import webelement_repository.Home_Page;

/*
 *  Navigate to the home page
	In the test 5 div, wait for a button to be displayed (note: the delay is random) 
	and then click it
    Once you've clicked the button, assert that a success message is displayed
    Assert that the button is now disabled
 */
/**
 * @author Vijay Ganesan
 */
@Listeners(listener.Listener_Implementation.class)
public class Test_5 extends Base_Test{
	@Test
	public void test_5()
	{
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		//click on button
		home.getTest5Button().click();
		//assert that a success message is displayed
		Assert.assertEquals(home.getSuccessMessage().isDisplayed(), true);
		Reporter.log("Success message is displayed-->"+home.getSuccessMessage().getText(),true);
		//Assert the button is now disabled
		Assert.assertEquals(home.getTest5Button().isEnabled(), false);
		Reporter.log("Button is disabled",true);
	}

}
