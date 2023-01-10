package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;


public class HelpCenter extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 16)
	public void helpCenter() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		HelpCenterPage help=new HelpCenterPage(driver);
		help.helpCenter();
		test.log(LogStatus.INFO, "HelpCenter page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("helpCenterTitle"));
		
		System.out.println("HelpCenter Test passed");	
	}
}