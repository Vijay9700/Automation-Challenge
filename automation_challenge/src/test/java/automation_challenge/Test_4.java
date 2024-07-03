package automation_challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_test.Base_Test;
import webelement_repository.Home_Page;
/*
 * Navigate to the home page In the test 4 div, 
 * assert that the first button is enabled and that the second button is disabled
 */
/**
 * @author Vijay Ganesan
 */
@Listeners(listener.Listener_Implementation.class)
public class Test_4 extends Base_Test {
	
	@Test
	public void test_4() {
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		//assert that the first button is enabled
		WebElement firstButton = home.getButtons().get(0);
		Assert.assertEquals(firstButton.isEnabled(), true);
		Reporter.log("First button is enabled",true);
		//Assert the second button is disabled
		WebElement secondButton = home.getButtons().get(1);
		Assert.assertEquals(secondButton.isEnabled(), false);
		Reporter.log("Second button is disabled",true);
	}

}
