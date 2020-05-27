package test_class;

import java.text.ParseException;

import org.testng.annotations.Test;

import Zestinitialization.Zest_Initialization;

public class Price_Comparision extends Zest_Initialization

{
	
    @Test(priority=1,description="Compare Price In Different Websites")
    public void ComparePrice() throws InterruptedException, ParseException
    {
    	compare.SearchingProduct_AmaZon("iPhone XR (64GB) - Yellow");
    	compare.Selectingiphone("Yellow");
    	compare.WindowHandle(1);
    	compare.ReadingIphonePrice();
    	compare.SwitchBackToMainWindow(compare.originalHandle);
    	compare.openingFlipkart();
    	compare.SearchProduct_Flipkart("iPhone XR (64GB) - Yellow","Yellow");
    	compare.SelctingIphone_Flipkart("Yellow");
    	compare.WindowHandle(2);
    	compare.ReadingIphoneprice_Flipkart();
    	compare.VerifyPriceDifference();
    	compare.SwitchBackToMainWindow(compare.Mainwindow);
    	
    	
    }
}
