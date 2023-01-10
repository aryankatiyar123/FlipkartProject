package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;


public class Careers extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 5)
	public void careers() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		CareersPage car=new CareersPage(driver);
		car.careers(PropertiesFile.getProperty("searchJob"));
		test.log(LogStatus.INFO, "Careers page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("careersTitle"));
		
		System.out.println("Careers Test passed");	
	}
}