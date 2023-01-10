package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class BecomeSellerPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(BecomeSellerPage.class);
	
	public BecomeSellerPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Become seller test functionality*****************
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]/span[1]")
	WebElement btn_StartSell;
	
	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement txt_MobileNo;
	
	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")
	WebElement txt_EmailId;
	
	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/input[1]")
	WebElement txt_GSTIN;
	
	@FindBy(xpath = "//span[contains(text(),'Register & Continue')]")
	WebElement btn_RegAndConti;
	
	public void becomeSeller(String mobileNO,String emailId,String gstIN) throws Throwable
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_BecomeSeller.click();
		btn_StartSell.click();
		txt_MobileNo.sendKeys(mobileNO);
		log.info("Sends the mobile number in website");
		txt_EmailId.sendKeys(emailId);
		log.info("Sends the email id to website");
		txt_GSTIN.sendKeys(gstIN);
		log.info("Sends the GSTIN to website");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_RegAndConti)).click();
		log.info("Click on Register & Continue button");
	}
}
