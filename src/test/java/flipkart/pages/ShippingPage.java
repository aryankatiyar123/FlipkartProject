package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class ShippingPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(ShippingPage.class);
	
	public ShippingPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*********Shipping test functionality************
	@FindBy(xpath = "//a[contains(text(),'Flights')]")
	WebElement btn_Flights;
	
	
	public void shipping() throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//------------------To go in the bottom of website---------------
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    log.info("Scrolled to bottom of flipkart website");
		
	    try 
	    {
	    	wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Shipping.click();
		log.info("Click on Shipping button");
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_Flights)).click();
		log.info("Click on flights button");
	}
}
