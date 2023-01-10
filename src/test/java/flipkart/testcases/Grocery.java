package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Grocery extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 15)
	public void grocery() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		GroceryPage gp=new GroceryPage(driver);
		gp.grocery(PropertiesFile.getProperty("pinCode"));
		test.log(LogStatus.INFO, "Grocery page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("groceryTitle"));
		
		System.out.println("Grocery Test passed");
	}
}