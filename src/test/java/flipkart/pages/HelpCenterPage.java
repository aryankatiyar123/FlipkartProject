package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class HelpCenterPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(HelpCenterPage.class);
	
	public HelpCenterPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************HelpCenter test functionality*******************
	@FindBy(xpath = "//div[contains(text(),'I want to track my order')]")
	WebElement btn_TrackOrder;
	
	@FindBy(xpath = "//span[contains(text(),'Postal Address')]")
	WebElement btn_PostalAdd;
	
	
	public void helpCenter() throws Throwable
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
		HomePage.btn_HelpCenter.click();
		log.info("Click on HelpCenter button");
		
		btn_TrackOrder.click();
		log.info("Track order button got clicked");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_PostalAdd)).click();
		log.info("Click on postal address button");
		HomePage.btn_Close.click();
	}
}
