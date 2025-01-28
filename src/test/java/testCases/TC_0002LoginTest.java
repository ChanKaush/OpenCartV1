package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_0002LoginTest extends BaseClass{
	
	@Test
	public void verify_login()
	{
		logger.info("****Starting TC_0002LoginTest*****");
		
		try {
		//since MyAccount and Login links are present on home Page , we need to access the Homepage objects
		
		//creating home page objects
		HomePage hp = new HomePage(driver); //driver is coming from BaseClass
		hp.clickMyAccount();
		hp.clickLogin();
		
	    //creating loginpage objects and call the methods 
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));     // getting  from properties file
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		 //creating MyAccountPage object
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists(); //capturing true/false value in a varible of boolean type
	  
		//Assert.assertEquals(targetPage, true,"Login failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC_0002LoginTest*****");
		
		
	
	}

	
}
