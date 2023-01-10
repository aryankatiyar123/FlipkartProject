package flipkart.pages;

import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class LoginAndCreateAccountPage extends HomePage
{
	WebDriver driver;
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(LoginAndCreateAccountPage.class);
	
	public LoginAndCreateAccountPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************Login test functionality*****************
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	WebElement txt_MobileNO;
	
	@FindBy(xpath = "//button[contains(text(),'Request OTP')]")
	WebElement btn_RequestOTP;
	
	
	//Create account test functionality
	@FindBy(xpath ="//a[contains(text(),'New to Flipkart? Create an account')]")
	WebElement btn_CreateAccount;
	
	@FindBy(xpath ="//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/button[1]")
	WebElement btn_Continue;
	
	@FindBy(xpath ="//body/div[@id='container']/div[1]/div[1]/div[1]/div[1]")
	WebElement btn_Tap;
	
	
	public void login(String mobileNO) throws InterruptedException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
	    {
	    	HomePage.btn_Close.click();
		} catch (Exception e) {		}
		HomePage.btn_Login.click();
		txt_MobileNO.sendKeys(mobileNO);
		log.info("Sends the mobile in website");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_RequestOTP)).click();
		log.info("Click on Request OTP option in website");
	}
	
	public void createAccount(String mobileNO) throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		try 
	    {
			wait.until(ExpectedConditions.visibilityOf(HomePage.btn_Close)).click();
		} catch (Exception e) {		}
		HomePage.btn_Login.click();
		btn_CreateAccount.click();
		log.info("Click on Create Account option in website");
		txt_MobileNO.sendKeys(mobileNO);
		log.info("Sends the mobile in website");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(btn_Continue)).click();
		log.info("Click on continue button");
	}
}
