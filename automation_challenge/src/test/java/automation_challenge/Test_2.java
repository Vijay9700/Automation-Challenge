package automation_challenge;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_test.Base_Test;
import webelement_repository.Home_Page;

/*
 * 	Navigate to the home page
	In the test 2 div, assert that there are three values in the listgroup
	Assert that the second list item's value is set to "List Item 2"
	Assert that the second list item's badge value is 6
 */
/**
 * @author Vijay Ganesan
 */

@Listeners(listener.Listener_Implementation.class)
public class Test_2 extends Base_Test{
	@Test
	public void test_2()
	{
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		//get the size and Assert there are three values
		int expected=3;
		int actual = home.getListGroup().size();
		Assert.assertEquals(actual, expected);
		Reporter.log("Three values present in the listgroup");
		//get the second list item value and Assert
		String secondListItem = home.getListItem2().getText().replace("6", "").trim();
		Assert.assertEquals(secondListItem, "List Item 2");
		Reporter.log("Second list item value is List Item 2");
		//get the second list item badge value and assert
		String secondItemBadge = home.getListBadge().get(1).getText();
		Assert.assertEquals(secondItemBadge, "6");
		Reporter.log("Second list item's badge value is 6");
	}

}
