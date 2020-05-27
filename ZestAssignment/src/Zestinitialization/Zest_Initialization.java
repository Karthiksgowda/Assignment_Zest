package Zestinitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageclass.ComparePrice;
import pageclass.SetUp;

public class Zest_Initialization 
{

	public static WebDriver driver;
	public static SetUp setup;
	public static ComparePrice compare;

	@BeforeClass

	public void Configuration() throws InterruptedException
	{
		driver=SetUp.launchbrowser();
		
		setup=PageFactory.initElements(driver, SetUp.class);
		compare=PageFactory.initElements(driver,ComparePrice.class);
		setup.OpeningBrowser(setup.URL);
	
	}
	
	@AfterClass
	public void ClosingBrowser()
	{
		driver.quit();
	}
}
