package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class GiftCardsPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(GiftCardsPage.class);
	
	public GiftCardsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************GiftCards test functionality*****************
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[3]/div[1]/a[1]/div[1]/div[1]/img[2]")
	WebElement btn_Wallet;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement txt_ReceEmail;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement txt_ReceName;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/select[1]")
	WebElement btn_CardValue;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/select[1]/option[5]")
	WebElement btn_Price;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]")
	WebElement btn_Buy;
	
	
	public void giftCards(String receEmail,String receName) throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_GiftCards.click();
		log.info("Click on GiftCards button");
		
		btn_Wallet.click();
		log.info("wallet option got clicked");
		txt_ReceEmail.sendKeys(receEmail);
		txt_ReceName.sendKeys(receName);
		btn_CardValue.click();
		btn_Price.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_Buy)).click();
		log.info("Click on buy button");
	}
}
