package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;


public class GiftCards extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 14)
	public void giftCards() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		GiftCardsPage gift=new GiftCardsPage(driver);
		gift.giftCards(PropertiesFile.getProperty("receEmail"),PropertiesFile.getProperty("receName"));
		test.log(LogStatus.INFO, "GiftCards page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website Title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("giftCardsTitle"));
		
		System.out.println("GiftCards Test passed");	
	}
}