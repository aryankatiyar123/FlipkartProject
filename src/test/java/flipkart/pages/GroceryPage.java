package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class GroceryPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(GroceryPage.class);
	
	public GroceryPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Grocery test functionality*****************
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")
	WebElement txt_PINCode;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]")
	WebElement btn_Location;

	
	public void grocery(String pinCode) throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Grocery.click();
		txt_PINCode.sendKeys(pinCode);
		log.info("Sends the pinCode in website");
		wait.until(ExpectedConditions.elementToBeClickable(btn_Location)).click();
		log.info("Location option got clicked in website");
	}
}
