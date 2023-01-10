package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class Cart extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 6)
	public void cart() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		CartPage cart=new CartPage(driver);
		cart.cart();
		test.log(LogStatus.INFO, "Cart page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("cartTitle"));
		
		System.out.println("Cart Test passed");	
	}
}