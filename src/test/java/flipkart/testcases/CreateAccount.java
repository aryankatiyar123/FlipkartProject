package flipkart.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.pages.*;
import flipkart.utilities.*;

public class CreateAccount  extends BasePage
{
	public WebDriverWait wait;
	
	@Test(priority = 8)
	public void newAccount() throws Throwable 
	{
		//***********Creating the object of class and calling a method**********
		LoginAndCreateAccountPage acccount=new LoginAndCreateAccountPage(driver);
		acccount.createAccount(PropertiesFile.getProperty("userMobileNumber"));
		test.log(LogStatus.INFO, "Create Account page functionality performed");
		
		test.log(LogStatus.INFO, "Asserting flipkart website contains");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(driver.getPageSource().contains(PropertiesFile.getProperty("actualText")));
		
		System.out.println("Create account Test passed");	
	}
}
