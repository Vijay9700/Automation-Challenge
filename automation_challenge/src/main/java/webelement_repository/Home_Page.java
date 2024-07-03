package webelement_repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * This is the class which will act as an web-element repository(POM CLASS)
 * Here all the web-elements stored for the further use
 */
/**
 * @author Vijay Ganesan
 */
public class Home_Page {
	//parameterized constructor
	public Home_Page(WebDriver driver)
	{
		//initializing the current web-element
		PageFactory.initElements(driver, this);
	}
	
	//email address text-field
	@FindAll({@FindBy(id = "inputEmail"),@FindBy(xpath = "//input[@placeholder='Email address']")})
	private WebElement emailAddressTextfield;
	
	//password text-field
	@FindAll({@FindBy(id = "inputPassword"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement passwordTextfield;
	
	//sign in button
	@FindAll({@FindBy(xpath = "//button[@type='submit']"),@FindBy(xpath = "//button[text()='Sign in']")})
	private WebElement signinButton;
	
	//list group
	@FindBy(xpath = "//li[@class=\"list-group-item justify-content-between\"]")
	private List<WebElement> listGroup;
	
	//list badge
	@FindBy(xpath = "//ul[@class='list-group']/li/span")
	private List<WebElement> listBadge;
	
	//all options
	@FindBy(xpath = "//a[@class='dropdown-item']")
	private List<WebElement> allOptions;
	
	//list item 2
	@FindBy(xpath = "//li[normalize-space(text()[1])='List Item 2' and name()!='span']")
	private WebElement listItem2;
	
	public WebElement getListItem2() {
		return listItem2;
	}

	//dropdown
	@FindBy(id = "dropdownMenuButton")
	private WebElement dropdown;
	
	//test 4-->buttons
	@FindBy(xpath = "//button[text()='Button']")
	private List<WebElement> buttons;
	
	//test 5-->button
	@FindBy(id = "test5-button")
	private WebElement test5Button;
	
	//success message
	@FindBy(id = "test5-alert")
	private WebElement successMessage;
	
	//column
	@FindBy(xpath = "//table[@class='table table-bordered table-dark']//tbody//tr")
	private List<WebElement> column;
	
	//row
	@FindBy(xpath = "//table[@class='table table-bordered table-dark']//tr[3]/td")
	private List<WebElement> row;
	
	//grid
	@FindBy(xpath = "//table[@class='table table-bordered table-dark']//thead")
	private List<WebElement> grid;

	public List<WebElement> getGrid() {
		return grid;
	}

	public List<WebElement> getColumn() {
		return column;
	}

	public List<WebElement> getRow() {
		return row;
	}

	public WebElement getEmailAddressTextfield() {
		return emailAddressTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getSigninButton() {
		return signinButton;
	}

	public List<WebElement> getListGroup() {
		return listGroup;
	}

	public List<WebElement> getListBadge() {
		return listBadge;
	}

	public List<WebElement> getAllOptions() {
		return allOptions;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public List<WebElement> getButtons() {
		return buttons;
	}

	public WebElement getTest5Button() {
		return test5Button;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}
	
}
