package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class CareersPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(CareersPage.class);
	
	public CareersPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Careers test functionality*****************
	@FindBy(xpath = "//body/div[1]/div[4]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
	WebElement txt_ExploreJob;
	
	@FindBy(xpath = "//body/div[1]/div[4]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[1]/img[1]")
	WebElement btn_Search;
	
	@FindBy(xpath = "//button[contains(text(),'Clear All')]")
	WebElement btn_ClearAll;
	
	
	public void careers(String searchJob) throws Throwable
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
		HomePage.btn_Careers.click();
		log.info("Click on Careers button");
		
		txt_ExploreJob.sendKeys(searchJob);
		log.info("Serach text send to the website");
		btn_Search.click();
		log.info("Search option got clicked");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_ClearAll)).click();
		log.info("Click on clear all  button");
	}
}

