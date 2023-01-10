package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CancelAndReturnsPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(CancelAndReturnsPage.class);
	
	public CancelAndReturnsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************CancelAndReturns test functionality*****************
	@FindBy(xpath = "//span[contains(text(),'Help with other issues')]")
	WebElement btn_OtherIssues;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]")
	WebElement btn_Order;
	
	@FindBy(xpath = "//button[contains(text(),'Login to select an item')]")
	WebElement btn_Login;
	
	
	public void cancel() throws Throwable
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
		HomePage.btn_Travel.click();
		log.info("Click on CancelAndReturns button");
		
		btn_OtherIssues.click();
		log.info("Other issues option got clicked");
		btn_Order.click();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_Login)).click();
		log.info("Click on Login button");
	}
}

