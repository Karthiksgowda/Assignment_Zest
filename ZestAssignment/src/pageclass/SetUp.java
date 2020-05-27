package pageclass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp
{

   public String URL="https://www.amazon.in/";
	public static WebDriver driver;
     public static WebDriver launchbrowser()
     {
    	System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromerdrivernew\\chromedriver.exe");
    	driver=new ChromeDriver();
    	MaximizePage();
    	return driver;
     }
     
     public void OpeningBrowser(String URL) throws InterruptedException
     {
    	 driver.get(URL);
         Thread.sleep(5000);
     }
     
     public static void MaximizePage()
     {
    	 driver.manage().window().maximize();
    	 
     }
    
}
