package Zestinitialization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageclass.SetUp;



public class CommonMethods 
{
	public void waitForElementPresence(String xpath) throws InterruptedException
	{
	      WebDriverWait wait=new WebDriverWait(SetUp.driver,45);
	      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	      Thread.sleep(5000);
	}
}
