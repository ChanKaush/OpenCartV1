package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
    WebElement txtFirstName;
	
	@FindBy(xpath ="//input[@id=\"input-lastname\"]")
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name=\"agree\"]")
	WebElement chkPolicy;
	
	@FindBy(xpath="//button[normalize-space()=\"Continue\"]")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()=\"Your Account Has Been Created!\"]")
	WebElement msgConfirmation;
	
	
	public void setFirstname(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		Actions act = new Actions(driver);
		act.moveToElement(chkPolicy).click().perform();
	}
	
	public void clickContinue()
	{
		btnContinue.sendKeys(Keys.RETURN);
	}
	
	//no validation done here only returning the msg
	public String getConfirmationMsg() {
	try
	{
		return(msgConfirmation.getText()); //extracting the text from the webelemnt and return
	}
	catch (Exception e)
	{
		return(e.getMessage()); //exception message will be returned if registration failed
	}
	
}
}
