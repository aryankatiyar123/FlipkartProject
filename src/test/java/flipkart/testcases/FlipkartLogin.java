package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.PropertiesFile;

public class FlipkartLogin extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 12)
	public void login() throws Throwable
	{	
		//***********Creating the object of class and calling a method**********
		LoginAndCreateAccountPage login=new LoginAndCreateAccountPage(driver);
		login.login(PropertiesFile.getProperty("userMobileNumber"));
		test.log(LogStatus.INFO, "Login page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website contains");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(driver.getPageSource().contains(PropertiesFile.getProperty("actualText")));
		
		System.out.println("Login Test passed");	
	}
}