package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class AppliancesPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(AppliancesPage.class);
	
	public AppliancesPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Appliances test functionality*****************
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[3]/div[1]/div[1]/a[1]/div[1]/div[1]/img[2]")
	WebElement btn_TV;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]")
	WebElement btn_FirstTV;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/span[1]/span[1]/*[1]")
	WebElement btn_Share;
	
	
	public void appliances() throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Appliences.click();
		log.info("Click on Appliances button");
		
		btn_TV.click();
		log.info("TV option got clicked");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_FirstTV)).click();
		log.info("Click on first TV option");
		btn_Share.click();
	}
}
