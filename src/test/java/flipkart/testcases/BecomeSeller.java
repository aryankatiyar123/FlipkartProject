package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class BecomeSeller extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 3,enabled = true)		//to not run this testcase use false instead of true
	public void seller() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		BecomeSellerPage seller=new BecomeSellerPage(driver);
		seller.becomeSeller(PropertiesFile.getProperty("userMobileNumber"),PropertiesFile.getProperty("emailId"),PropertiesFile.getProperty("GSTIN"));
		test.log(LogStatus.INFO, "Seller page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("sellerTitle"));

		System.out.println("Seller Test passed");
	}
}
