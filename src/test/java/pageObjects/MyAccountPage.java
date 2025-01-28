package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	// locators
	@FindBy(xpath = "//h2[normalize-space()=\"My Account\"]") // MyAcoount Page Heading
	WebElement msgHeading;

	@FindBy(xpath="//a[@class=\"list-group-item\"][normalize-space()=\"Logout\"]")
	WebElement lnkLogout;  //added in step6
	
	// Action Method (without validation)

	public boolean isMyAccountPageExists() {
		try 
		{
			return (msgHeading.isDisplayed()); // return true or false
		} catch (Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
