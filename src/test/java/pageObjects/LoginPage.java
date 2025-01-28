package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	//Actions methods
	
	public void setEmail(String email)//passing parameters from test case
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) //passing parameters from test case
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
