package automation_challenge;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_test.Base_Test;
import webelement_repository.Home_Page;

/*
 * Navigate to the home page
 * Write a method that allows you to find the value of any cell on the grid
 * Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
 * Assert that the value of the cell is "Ventosanzap"
 */
/**
 * @author Vijay Ganesan
 */
@Listeners(listener.Listener_Implementation.class)
public class Test_6 extends Base_Test {
	
	@Test
	public void test_6() {
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		gridValues();
		String valueOf2_2 = findValue(2, 2);
		Assert.assertEquals(valueOf2_2, "Ventosanzap");
		Reporter.log("Value of the cell is Ventosanzap",true);
	}
	
	public String findValue(int columnNo,int rowNo)
	{
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		String rowValue=home.getRow().get(rowNo).getText();
		return rowValue;
	}
	
	public void gridValues()
	{
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		int size = home.getGrid().size();
		List<String> allGridValue=new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			String text = home.getGrid().get(i).getText();
			allGridValue.add(text);
		}
		for (String gridValue : allGridValue) {
			Reporter.log(gridValue,true);
		}
	}
}
