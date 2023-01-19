package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class TravelPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(TravelPage.class);
	
	public TravelPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Travel test functionality*****************
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[5]/div[1]/div[1]/a[1]/div[1]/img[2]")
	WebElement btn_TopDeal;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[3]/div[1]/div[1]/a[1]/div[1]/img[2]")
	WebElement btn_UseCode;
	
	
	public void travel() throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Travel.click();
		log.info("Click on travel");
//		btn_TopDeal.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_TopDeal)).click();
		log.info("Top deal option clicked");
		wait.until(ExpectedConditions.elementToBeClickable(btn_UseCode)).click();
		log.info("Click on use code in website");
	}
}
