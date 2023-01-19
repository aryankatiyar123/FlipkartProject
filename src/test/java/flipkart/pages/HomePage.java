package flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage
{	
	//----------------Cut the login box--------------
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	public static WebElement btn_Close;
	
	
	//1----------------Login path------------------1
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	public static WebElement btn_Login;
	
	
	//2--------------Search the product------------2
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	public static WebElement txt_SearchProduct;
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]")
	public static WebElement btn_Search;
	
	//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]/div[1]
	//3--------------Grocery path in website-----------3
	@FindBy(xpath = "//div[contains(text(),'Grocery')]")
	public static WebElement btn_Grocery;
	
	
	//4-------------------Mobiles path-----------------4
	@FindBy(xpath = "//div[contains(text(),'Mobiles')]")
	public static WebElement btn_Mobiles;
	
	
	//5-------------------Appliences path---------------5
	@FindBy(xpath = "//div[contains(text(),'Appliances')]")
	public static WebElement btn_Appliences;
	
	
	//6-------------------Travel path----------------6
	@FindBy(xpath = "//div[contains(text(),'Travel')]")
	public static WebElement btn_Travel;
	
	
	//7-------------------Top offers path----------------7
	@FindBy(xpath = "//div[contains(text(),'Top Offers')]")
	public static WebElement btn_TopOffers;
	

	//8-----------------Become a Seller path--------------8
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/a[1]/span[1]")
	public static WebElement btn_BecomeSeller;
	
	
	//9-----------------Cart path-------------------9
	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	public static WebElement btn_Cart;
	
	
	//10---------------ExplorePlus path------------10
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")
	public static WebElement btn_ExplorePlus;
	
	
	//11----------------Deal path------------------11
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public static WebElement btn_Deal;
	
	
	//12---------------Fashion path----------------12
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[8]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public static WebElement btn_Fashion;
	
	
	//13----------------Advertise path-------------13
	@FindBy(xpath = "//span[contains(text(),'Advertise')]")
	public static WebElement btn_Advertise;
	
	
	//14--------------Gift Cards button path--------------14
	@FindBy(xpath = "//span[contains(text(),'Gift Cards')]")
	public static WebElement btn_GiftCards;
	
	
	//15--------------Help Center button path-------------15
	@FindBy(xpath = "//span[contains(text(),'Help Center')]")
	public static WebElement btn_HelpCenter;

	
	//16--------------Careers button path----------16
	@FindBy(xpath = "//a[contains(text(),'Careers')]")
	public static WebElement btn_Careers;
	
	
	//17--------------Flipkart stories path-----------------17
	@FindBy(xpath = "//a[contains(text(),'Flipkart Stories')]")
	public static WebElement btn_FlipStories;
	
	
	//18-------------Shipping button path-----------18
	@FindBy(xpath = "//a[contains(text(),'Shipping')]")
	public static WebElement btn_Shipping;
	
	
	//19------------Cancellation & Returns path------------------19
	@FindBy(xpath = "//a[contains(text(),'Cancellation & Returns')]")
	public static WebElement btn_CanReturns;
	
	
	//20-----------Press button path-------------20
	@FindBy(xpath = "//a[contains(text(),'Press')]")
	public static WebElement btn_Press;
	
	
	//21-----------Corporate information button path-------------21
	@FindBy(xpath = "//a[contains(text(),'Corporate Information')]")
	public static WebElement btn_CorporateInfo;
		
}
