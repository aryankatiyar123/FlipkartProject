package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class CorporateInfoPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(CorporateInfoPage.class);
	
	public CorporateInfoPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************CorporateInfo test functionality*****************
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[2]/a[1]/div[1]/div[1]")
	WebElement btn_AnnualReturn;
	
	
	public void corporateInfo() throws Throwable
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
		HomePage.btn_CorporateInfo.click();
		log.info("Click on CorporateInfo button");
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_AnnualReturn)).click();
		log.info("Click on AnnualReturn pdf in website");
	}
}
