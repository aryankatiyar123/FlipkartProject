package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class MobilesPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(MobilesPage.class);
	
	public MobilesPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Mobiles test functionality*****************
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")
	WebElement btn_ShopNow;
	
	@FindBy(xpath = "//div[contains(text(),'Newest First')]")
	WebElement btn_NewestFirst;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[2]/div[1]/span[1]/label[1]/div[1]")
	WebElement btn_AddToCompare;
	
	public void mobiles() throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Mobiles.click();
		
		btn_ShopNow.click();
		log.info("Shop now button clicked");
		btn_NewestFirst.click();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_AddToCompare)).click();
		log.info("Click on add to compare option");
	}
}
