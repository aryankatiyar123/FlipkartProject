package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Appliances extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 2,enabled = true)	//to not run this testcase use false instead of true
	public void appliance() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		AppliancesPage app=new AppliancesPage(driver);
		app.appliances();
		test.log(LogStatus.INFO, "Appliances page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("applianceTitle"));
		
		System.out.println("Appliances Test passed");	
	}
}