package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	//Constructor that would be extended to all other page object classes

    public BasePage(WebDriver driver)  //driver recievd from child page object classes 
    {
    	this.driver = driver;  //assigning the local to class variable
    	PageFactory.initElements(driver, this); //initiating the driver
    }
}
