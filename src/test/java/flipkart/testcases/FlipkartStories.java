package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;


public class FlipkartStories extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 13)
	public void flipkartStories() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		FlipkartStoriesPage story=new FlipkartStoriesPage(driver);
		story.flipkartStories();
		test.log(LogStatus.INFO, "FlipkartStories page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("storiesTitle"));
		
		System.out.println("FlipkartStories Test passed");	
	}
}