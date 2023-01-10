package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Mobiles extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 17)
	public void mobiles() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		MobilesPage mob=new MobilesPage(driver);
		mob.mobiles();
		test.log(LogStatus.INFO, "Mobile page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("mobilesTitle"));
		
		System.out.println("Mobiles Test passed");	
	}
}