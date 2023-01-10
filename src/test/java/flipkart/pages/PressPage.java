package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class PressPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(PressPage.class);
	
	public PressPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Press test functionality*****************
	@FindBy(xpath = "//header/div[@id='ast-desktop-header']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[6]/a[1]")
	WebElement btn_Newsroom;
	
	@FindBy(xpath = "//header/div[@id='ast-desktop-header']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[1]/a[1]")
	WebElement btn_ViewAll;
	
	
	public void press() throws Throwable
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
		HomePage.btn_Press.click();
		log.info("Click on Press button");
		
		btn_Newsroom.click();
		log.info("Newsroom option got clicked");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_ViewAll)).click();
		log.info("Click on viewAll button");
	}
}
