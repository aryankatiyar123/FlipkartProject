package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Deal extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 9)
	public void deal() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		DealPage dp=new DealPage(driver);
		dp.deal();
		test.log(LogStatus.INFO, "Deal page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("dealTitle"));
		
		System.out.println("Deal Test passed");	
	}
}