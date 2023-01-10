package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class ExplorePlus extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 10)
	public void explorePlus() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		ExplorePlusPage explorePlus=new ExplorePlusPage(driver);
		explorePlus.explorePlus();
		test.log(LogStatus.INFO, "ExplorePlus page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("exploreTitle"));
		
		System.out.println("ExplorePlus Test passed");	
	}
}