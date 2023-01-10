package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;


public class Shipping extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 20)
	public void shipp() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		ShippingPage ship=new ShippingPage(driver);
		ship.shipping();
		test.log(LogStatus.INFO, "Shipping page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("shippingTitle"));
		
		System.out.println("Shipping Test passed");	
	}
}