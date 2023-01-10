package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Fashion extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 11)
	public void fashion() throws Throwable
	{
		//***********Creating the object of class and calling a method**********
		FashionPage fash=new FashionPage(driver);
		fash.fashion();
		test.log(LogStatus.INFO, "Fashion page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("fashionTitle"));
		
		System.out.println("Fashion Test passed");	
	}
}