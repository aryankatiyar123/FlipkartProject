package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class CancelAndReturns extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 4,enabled = true)		//to not run this testcase use false instead of true
	public void cancel() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		CancelAndReturnsPage can=new CancelAndReturnsPage(driver);
		can.cancel();
		test.log(LogStatus.INFO, "CancelAndReturns page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("cancelTitle"));
		
		System.out.println("CancelAndReturns Test passed");	
	}
}
