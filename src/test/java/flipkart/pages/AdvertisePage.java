package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class AdvertisePage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(AdvertisePage.class);
	
	public AdvertisePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Advertise test functionality*****************
	@FindBy(xpath = "//body/app-root[1]/flipscore-ext[1]/div[1]/div[1]/div[1]/div[3]/search[1]/div[1]/input[1]")
	WebElement txt_SearchBrand;
	
	@FindBy(xpath = "//body/app-root[1]/flipscore-ext[1]/div[1]/div[1]/div[1]/div[3]/search[1]/div[1]/div[2]/infinite-scroll[1]/div[1]/div[1]/div[1]/div[1]/brand-desc[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement btn_FirstBrand;
	
	@FindBy(xpath = "//a[contains(text(),'About Us')]")
	WebElement btn_AboutUs;
	
	
	public void advertise(String brand) throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//------------------To go in bottom of the website---------------
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    log.info("Scrolled to bottom of flipkart website");
		
	    try 
	    {
	    	wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Advertise.click();
		log.info("Click on Advertise button");
		
		txt_SearchBrand.sendKeys(brand);
		log.info("Brand name send to website");
		//wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_FirstBrand)).click();
		log.info("Click on firstBrand in website");
		btn_AboutUs.click();
	}
}
