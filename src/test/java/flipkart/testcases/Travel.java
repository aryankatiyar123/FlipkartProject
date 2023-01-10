package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Travel extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 22)
	public void travel() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		TravelPage tp=new TravelPage(driver);
		tp.travel();
		test.log(LogStatus.INFO, "Travel page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("travelTitle"));
		
		System.out.println("Travel Test passed");	
	}
}