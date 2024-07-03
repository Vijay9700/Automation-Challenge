package automation_challenge;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_test.Base_Test;
import file_utility.Read_ExcelData;
import listener.Listener_Implementation;
import webelement_repository.Home_Page;

/*
 * 	Navigate to the home page
	Assert that both the email address and password inputs are present as well as the login button
	Enter in an email address and password combination into the respective fields
 */
/**
 * @author Vijay Ganesan
 */
@Listeners(listener.Listener_Implementation.class)
public class Test_1 extends Base_Test {
	
	@Test
	public void test_1() throws EncryptedDocumentException, IOException {
		WebDriver driver=Base_Test.driver;
		Home_Page home=new Home_Page(driver);
		Read_ExcelData excel=new Read_ExcelData();
		//EMAIL TEXTFIELD
		Assert.assertEquals(home.getEmailAddressTextfield().isDisplayed(),true, "EMAIL TEXT FIELD IS PRESENT");
		home.getEmailAddressTextfield().sendKeys(excel.readExcel("signin", 1, 0));
		//PASSWORD TEXTFIELD
		Assert.assertEquals(home.getPasswordTextfield().isDisplayed(),true, "PASSWORD TEXTFIELD IS PRESENT");
		home.getPasswordTextfield().sendKeys(excel.readExcel("signin", 1, 1));
		//SIGNIN BUTTON
		Assert.assertEquals(home.getSigninButton().isDisplayed(),true, "SIGNIN BUTTON IS PRESENT");
		home.getSigninButton().click();
	}

}
