package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class CorporateInfo extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 7)
	public void corporate() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		CorporateInfoPage corpo=new CorporateInfoPage(driver);
		corpo.corporateInfo();
		test.log(LogStatus.INFO, "CorporateInfo page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("corporateTitle"));
		
		System.out.println("CorporateInfo Test passed");	
	}
}