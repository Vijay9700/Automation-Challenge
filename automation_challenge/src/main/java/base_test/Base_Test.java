package base_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import file_utility.Read_PropertiesData;

/**
 * @author Vijay Ganesan
 */
public class Base_Test {
	public static WebDriver driver=null;
	Read_PropertiesData property=new Read_PropertiesData();
	/*
	 * @BeforeClass
	 * The actions needed before the core script execution
	 */
	@BeforeClass
	public void browserLaunch() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(property.read_Property("url"));
	}
	
	/*
	 * @AfterClass
	 * The actions needed after the core script execution
	 */
	@AfterClass
	public void quitBrowser()
	{
		driver.manage().window().maximize();
		driver.quit();
	}

}
