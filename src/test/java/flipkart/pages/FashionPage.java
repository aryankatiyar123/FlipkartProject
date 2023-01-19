package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class FashionPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(FashionPage.class);
	
	public FashionPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Fashion test functionality*****************
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]/div[1]/img[1]")
	WebElement btn_FirstProduct;
	
	@FindBy(xpath = "//div[contains(text(),'Price -- Low to High')]")
	WebElement btn_Price;
	
	public void fashion() throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Fashion.click();
		btn_FirstProduct.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_Price)).click();
		log.info("Click on price button");
	}
}
