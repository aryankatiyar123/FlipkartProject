package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class SearchProduct extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 19)
	public void searchProduct() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		SearchProductPage search=new SearchProductPage(driver);
		search.searchProduct(PropertiesFile.getProperty("searchText"));
		test.log(LogStatus.INFO, "Search page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website title");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(),PropertiesFile.getProperty("searchTitle"));
		
		System.out.println("SearchProduct Test passed");	
	}
}