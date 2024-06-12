package rahulshettyacedemy.testcases;

import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
import pageobject.productcatalog;
import rahulshettyacedemy.TestComponents.basetest;

public class errorvalidation extends basetest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=rahulshettyacedemy.TestComponents.Retry.class)
	public void loginerrorvalidation() throws IOException, InterruptedException 
	{
		
		String productname="ZARA COAT 3";

    productcatalog pc=ldp.loginapplication("artesting988@gmail.com", "Extra@12");
  
    Assert.assertEquals("Incorrect email password.", ldp.geterromessageforlogin());

   
	}
    
	@Test
	public void producterrorvalidation() throws IOException, InterruptedException 
	{
		
    String productname="ZARA COAT 3";
    productcatalog pc=ldp.loginapplication("artesting98@gmail.com", "Extra@12");
    List <WebElement> products=pc.getProductList(); 	
    pc.addProductToCart(productname);
    cartpage crt= pc.gotocartpage();			

    Boolean match=crt.VerifyProdductDisplay("ZARA COAT 33");
    Assert.assertTrue(match);
   
    
   
	}
    
   
   		
}

