package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Advertise extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 1,enabled = true)	//to not run this testcase use false instead of true
	public void advertise() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		AdvertisePage adver=new AdvertisePage(driver);
		adver.advertise(PropertiesFile.getProperty("searchText"));
		test.log(LogStatus.INFO, "Brand page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("advertiseTitle"));
		
		System.out.println("Advertise Test passed");	
	}
}