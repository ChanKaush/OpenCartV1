package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public WebDriver driver;
	public Logger logger; //log4j
	public Properties p; //class
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		//loading config.properties file
		FileReader file = new FileReader(".//src/test/resources//config.properties");
		p = new Properties(); //creating object of properties class 
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass()); //using This keyword , it will get the class dynamically at the run time
		
		switch(br.toLowerCase())
		{
		case "chrome": driver =new ChromeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		case "Edge" : driver = new EdgeDriver();break;
		default: System.out.println("Invalid browser name..."); return; //return means it will exit fromt he execution further
		}
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://demo-opencart.com"); hardcoded earlier
		driver.get(p.getProperty("appURL1")); //reading URl from properties file
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	

	//Method created for String 
	public String randomString()
	{
		@SuppressWarnings("deprecation")
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	//Method craeted for numbers
	
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		String generatedNumber  = RandomStringUtils.randomNumeric(9);
		return generatedNumber;
	}
	
	//Method Created for Alphanumeric
	
	@SuppressWarnings("deprecation")
	public String randomAlphaNum()
	{
		String generatedAlphaNumeric = RandomStringUtils.randomAlphanumeric(8);
	    return generatedAlphaNumeric;
	}

}
