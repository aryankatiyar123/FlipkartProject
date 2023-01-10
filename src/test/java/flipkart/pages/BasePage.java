package flipkart.pages;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.*;

import flipkart.testcases.ReadExcelData;
import flipkart.utilities.*;

public class BasePage 
{
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	ChromeOptions options=new ChromeOptions();
	FirefoxOptions optionsFF=new FirefoxOptions();
	EdgeOptions optionsE=new EdgeOptions();
	public WebDriverWait wait;
	Logger log=LogManager.getLogger(BasePage.class);
	
	@BeforeSuite
	public void allSetup()
	{
		String browserName=PropertiesFile.getProperty("browser");
		if(browserName.toLowerCase().equals("chrome"))
		{
			//*****************setting path for Chrome driver*****************
			System.setProperty(PropertiesFile.getProperty("chromeDriverProperty"), System.getProperty("user.dir")+PropertiesFile.getProperty("chromeDriverPath"));
			
			//*********initializing driver as Chrome driver**********
			options.addArguments(PropertiesFile.getProperty("mode"));
			driver = new ChromeDriver(options);
			
			//options.addArguments("--incognito");
			//options.addArguments("--disable-site-isolation-trials");	
		}
		else if (browserName.equals("FF")) 
		{
			//*****************setting path for FireFox driver*****************
			System.setProperty(PropertiesFile.getProperty("firefoxDriverProperty"), System.getProperty("user.dir")+PropertiesFile.getProperty("firefoxDriverPath"));
			optionsFF.addArguments(PropertiesFile.getProperty("mode"));
			driver = new FirefoxDriver(optionsFF);
		}
		else if(browserName.equals("Edge"))
		{
			//*****************setting path for Edge driver*****************
			System.setProperty(PropertiesFile.getProperty("microsoftEdgeDriverProperty"), System.getProperty("user.dir")+PropertiesFile.getProperty("microsoftEdgeDriverPath"));
			optionsE.addArguments(PropertiesFile.getProperty("mode"));
			driver=new EdgeDriver(optionsE);
		}
		else
		{
			System.out.println("No browser name will be provided");
		}
		
		//*******Maximizing the window********
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		extent=ExtentReportManager.getInstance("reports//Extent_flipkart.html");
		
		driver.get(PropertiesFile.getProperty("url"));
	}
	@BeforeTest
	public void openingURL()
	{
		//*********navigating to application*********
		//driver.get(PropertiesFile.getProperty("url"));
	}
	
	@BeforeMethod
	public void startTest(Method method)
	{
		test=extent.startTest(method.getName());
		test.log(LogStatus.INFO, "Method called "+method.getName());
		System.out.println();
		log.info(method.getName()+" method called.");
		
		//***********Reading data from excel file******************
		if (ReadExcelData.isExecuteCase(method.getName()).equalsIgnoreCase("no")) throw new SkipException("Skiped");
	}
	
	@AfterMethod
	public void status(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, result.getName()+"_Test case got passed");
			log.info("Test "+result.getMethod().getMethodName()+" pass.");
		}
		else if(result.getStatus()==ITestResult.FAILURE) 
		{
			String screenPath=ScreenShots.takeScreenshot(driver, result.getTestContext().getName()+"_"+result.getName()+"_TestFailed_"+System.currentTimeMillis());
			test.log(LogStatus.ERROR, result.getThrowable());
			
			test.log(LogStatus.FAIL,result.getTestContext().getName()+"_"+result.getName()+"_Test case got failed");
			log.error("Test "+result.getMethod().getMethodName()+" failed.");
			test.log(LogStatus.FAIL,test.addScreenCapture(screenPath));
			log.info("ScreenShot taken successfuly");
		}
		else
		{
			test.log(LogStatus.SKIP, result.getThrowable());
			log.info("Test "+result.getMethod()+" skipped.");
		}
		extent.flush();
		extent.endTest(test);
	}
	@AfterSuite
	public void exit() 
	{
		//***quitting the driver***
		driver.quit();
	}
}
