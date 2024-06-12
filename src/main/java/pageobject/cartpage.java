package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobject.AbstractComponent.AbstractComponents;

public class cartpage extends AbstractComponents {
 WebDriver driver;
 
 
 @FindBy(css=".totalRow button")
 WebElement checkoutEle;
 
 
 @FindBy(css=".cartSection h3")
 private List<WebElement> cardproducts;
	
	
	
	public cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	
	public boolean VerifyProdductDisplay(String productname)
	{
		boolean match= cardproducts.stream().anyMatch(cardproduct->cardproduct.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public checkoutPage goToCheckout() 
	{
		checkoutEle.click();
		return new checkoutPage(driver);
	}
	
}
