package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class TopOffers extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 21)
	public void topOffers() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		TopOffersPage top=new TopOffersPage(driver);
		top.topOffers();
		test.log(LogStatus.INFO, "TopOffers page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("topOffersTitle"));
		
		System.out.println("TopOffers Test passed");	
	}
}