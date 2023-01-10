package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;


public class Press extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 18)
	public void press() throws Throwable
	{
		//***********Creating the object of class and calling a method**********
		PressPage press=new PressPage(driver);
		press.press();
		test.log(LogStatus.INFO, "Press page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("pressTitle"));
		
		System.out.println("Press Test passed");	
	}
}