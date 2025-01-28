package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistraionTest extends BaseClass{

	@Test
	public void verify_account_registration()
	{
		logger.info("****Starting TC_001AccountRegistraionTest   ****");
		try {
		HomePage hp = new HomePage(driver); //created an object for the homepage to access its methods
		hp.clickMyAccount();
		logger.info("**** Clicked on MyAccount Link ***");
		
		hp.clickRegister();
		logger.info("**** Clicked on Register Link ***");
		
		logger.info("****Providing customer details ****");
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		regpage.setFirstname(randomString().toUpperCase()); //no need to hardcoded the data
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //calling the method
		regpage.setPassword(randomAlphaNum());
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("****Validating expected message***");
		String confmsg=regpage.getConfirmationMsg();
		
		//to get the error and debug logs 
		if(confmsg.equals("Your Account Has Been Created!"))
			{
			Assert.assertTrue(true);
			}
		else
		{
			logger.error(" Test Failed "); //capture the error logs
			logger.debug(" Debug Logs "); //capture the debug logs
			Assert.assertTrue(false);
		}
		
		   }
		catch(Exception e)
		{
				Assert.fail(); //we are failing the test
		}
		logger.info("****Finished TC_001AccountRegistrationTest ***");
		}
	
	
}
