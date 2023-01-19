package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class CartPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(CartPage.class);
	
	public CartPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Cart test functionality*****************
	@FindBy(xpath = "//span[contains(text(),'Shop now')]")
	WebElement btn_ShopNow;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]/div[1]")
	WebElement btn_Grocery;
	
	public void cart() throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Cart.click();
		btn_Grocery.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_ShopNow)).click();
		log.info("Click on shopNow");
	}
}
