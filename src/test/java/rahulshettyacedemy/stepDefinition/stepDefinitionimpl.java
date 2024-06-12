package rahulshettyacedemy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.cartpage;
import pageobject.checkoutPage;
import pageobject.confirmationpage;
import pageobject.landingppage;
import pageobject.productcatalog;
import rahulshettyacedemy.TestComponents.basetest;

public class stepDefinitionimpl extends basetest {
	
	public landingppage ldp;
	public productcatalog pc;
	public cartpage crt;
	public checkoutPage checkoutPage;
	public confirmationpage confirmationpage;
	@Given ("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		ldp=launchapplication();
	}
	
	
	@Given("^Logged in with user name (.+) and Passwoerd (.+)$")
	public void logged_in_username_and_password(String username,String password)
	{
		pc=ldp.loginapplication(username, password);
	}
	
	@When("^I add product (.+) to cart And checkout (.+) and submit the order$")
	public void i_add_product_zara_coat_to_cart_and_checkout_zara_coat_and_submit_the_order(String productName,String productName1) throws InterruptedException
	{
		List <WebElement> products=pc.getProductList();    	
		
	    pc.addProductToCart(productName);
	     crt= pc.gotocartpage();				    
	    Boolean match=crt.VerifyProdductDisplay(productName);
	    
	    Assert.assertTrue(match);
	     checkoutPage= crt.goToCheckout();
	    checkoutPage.selectCountry("india");
	    confirmationpage=checkoutPage.submitOrders();
	    
	}
	
	
	
	@Then("{string} meaasge is displayed on confirmationpage")
	public void meaasge_is_isplayed_on_confirmationpage(String string)
	{
		String confirmMessage=  confirmationpage.getconfirmationmessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void something_message_is_displayed(String str)
	{
		Assert.assertEquals(str, ldp.geterromessageforlogin());
		driver.close();
	}
}
