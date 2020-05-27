package pageclass;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import Zestinitialization.CommonMethods;
import Zestinitialization.Zest_Initialization;

public class ComparePrice extends CommonMethods
{
	
	JavascriptExecutor js=(JavascriptExecutor)Zest_Initialization.driver;
	String URL="https://www.flipkart.com/";
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement ProductSearchbox_AmaZon;
	
	@FindBy(id="nav-search-submit-text")
	private WebElement SearchButton_Amazon;
	
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	private WebElement Iphoneprice_Amazo;
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement ProductSearchBox_Flipkart;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement FlipkartLoginCloseButton;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	private WebElement Iphoneprice_Flipkart;
	
    public void SearchingProduct_AmaZon(String Product) throws InterruptedException
    {
    	ProductSearchbox_AmaZon.sendKeys(Product);
    	ProductSearchbox_AmaZon.submit();
    	Thread.sleep(3000);
    }
        
    public void Selectingiphone(String Colour)
    {
    	Zest_Initialization.driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone XR (64GB) - "+Colour+"')]")).click();
    	
    }
    
    public String originalHandle;
    public void WindowHandle(int tabNumber) throws InterruptedException
    {
    	originalHandle = Zest_Initialization.driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (Zest_Initialization.driver.getWindowHandles());
		Zest_Initialization.driver.switchTo().window(tabs.get(tabNumber));
		Thread.sleep(5000);
    }
    
    static long iphoneprice_Amazon;
    static long iphoneprice_Flipkart;
    
    NumberFormat format=NumberFormat.getInstance(Locale.US);
    public void ReadingIphonePrice() throws ParseException
    {
    	String Iphone = Iphoneprice_Amazo.getText();
    	String[] price=Iphone.split(" ");
    	 iphoneprice_Amazon = (long) format.parse(price[1]);
    	Reporter.log("Iphone Price In Amazon Is :"+iphoneprice_Amazon,true);    	
    }
    
    public void SwitchBackToMainWindow(String Window)
    {
    	Zest_Initialization.driver.close();
    	Zest_Initialization.driver.switchTo().window(originalHandle);
    }
    
    public String Mainwindow;
    public void openingFlipkart() throws InterruptedException
    {
    	js.executeScript("window.open()");
    	 Mainwindow = Zest_Initialization.driver.getWindowHandle();
    	Zest_Initialization.driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		ArrayList<String> tabs = new ArrayList<String> (Zest_Initialization.driver.getWindowHandles());
		Zest_Initialization.driver.switchTo().window(tabs.get(1));
		Zest_Initialization.driver.get(URL);
		waitForElementPresence("//button[@class='_2AkmmA _29YdH8']");
    }
    
    public void SearchProduct_Flipkart(String Product,String Colour) throws InterruptedException
    {
    	try
    	{
    		FlipkartLoginCloseButton.isDisplayed();
    		FlipkartLoginCloseButton.click();
    		Thread.sleep(3000);
      	}
    	
    	catch (Exception e) 
    	{
    	}
    	ProductSearchBox_Flipkart.sendKeys(Product);
    	Thread.sleep(3000);
    	ProductSearchBox_Flipkart.submit();
    	waitForElementPresence("//div[contains(text(),'Apple iPhone XR ("+Colour+", 64 GB)')]");
    	Thread.sleep(3000);
    }
    
    public void SelctingIphone_Flipkart(String Colour)
    {
    	Zest_Initialization.driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone XR ("+Colour+", 64 GB)')]")).click();
    }
    
    public void ReadingIphoneprice_Flipkart() throws ParseException
    {
    	String Iphone=Iphoneprice_Flipkart.getText().substring(1);
    	iphoneprice_Flipkart = (long)format.parse(Iphone);
    	Reporter.log("Iphone Price In Flipkart Is :"+iphoneprice_Flipkart,true);
    }
    
    public void VerifyPriceDifference()
    {
    	
    	if(iphoneprice_Flipkart>iphoneprice_Amazon)
    	{
    		Reporter.log("Iphone Price In Amazon Is Lesser When Compare To Flipkart",true);
    	}
    	else if(iphoneprice_Flipkart==iphoneprice_Amazon)
    	{
    		Reporter.log("iphone Price Is Same In Amazon And Flipkart",true);
    	}
    	else
    	{
    		Reporter.log("Iphone Price In Flipkart Is Lesser When Compare To Amazon",true);
    	}
    }
}

