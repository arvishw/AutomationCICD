package rahulshettyacedemy.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.cartpage;
import pageobject.checkoutPage;
import pageobject.confirmationpage;
import pageobject.landingppage;
import pageobject.orderpage;
import pageobject.productcatalog;
import rahulshettyacedemy.TestComponents.basetest;

public class Submitorder extends basetest {
	String productname="ZARA COAT 3";
	
	@Test (dataProvider = "getData", groups= {"pruchaseorder"})
	public void submitorder(HashMap< String, String> input) throws IOException, InterruptedException 
	{
		
	

    productcatalog pc=ldp.loginapplication(input.get("email"), input.get("password"));
    
    List <WebElement> products=pc.getProductList();
    	
    pc.addProductToCart(input.get("productname"));
    cartpage crt= pc.gotocartpage();			
    
    
    Boolean match=crt.VerifyProdductDisplay(input.get("productname"));
    
    Assert.assertTrue(match);
    checkoutPage  checkoutPage= crt.goToCheckout();
    checkoutPage.selectCountry("india");
    confirmationpage confirmationpage=checkoutPage.submitOrders();
  String confirmMessage=  confirmationpage.getconfirmationmessage();
  
  System.out.println(confirmMessage);
    
  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    
   
	}
    
	@Test(dependsOnMethods= {"submitorder"})
	public void orderHistory()
	
	{
		
		productcatalog pc=ldp.loginapplication("artesting98@gmail.com", "Extra@12");
		orderpage ord=pc.gotorderpage();
		Assert.assertTrue(ord.VerifyorderDisplay(productname));
		
	}
	
	
    
	@DataProvider
	public Object[][] getData() throws IOException
	{
		

		List<HashMap<String,String>> data=getJsonDatatoMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacedemy//data//purchaseorder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
    
   
   		
}
//HashMap< String, String> map=new HashMap< String, String>();
//map.put("email", "artesting98@gmail.com");
//map.put("password", "Extra@12");
//map.put("productname", "ZARA COAT 3");
//
//
//HashMap< String, String> map1=new HashMap< String, String>();
//map1.put("email", "artesting98@gmail.com");
//map1.put("password", "Extra@12");
//map1.put("productname", "ADIDAS ORIGINAL");
