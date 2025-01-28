package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//constructor(same name) created to invoke the parent class constructor
	public HomePage(WebDriver driver) //this driver will comne from test case
	{
		super(driver); 
		//instead of writing page fatory stmnt , we passing the driver to the parent(Base)class constrcutor 
	    //inheritance concept- can invoke the immediate parent variable, method or constructor
		//by using super keyword
	}
	
	
	@FindBy(xpath ="//span[normalize-space()='My Account']") 
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()=\"Login\"]")
	WebElement lnkLogin;
	

	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
