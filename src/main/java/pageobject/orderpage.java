package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobject.AbstractComponent.AbstractComponents;

public class orderpage extends AbstractComponents {
 WebDriver driver;
 
 
 @FindBy(css=".totalRow button")
 WebElement checkoutEle;
 
 
 @FindBy(css="tr td:nth-child(3)")
 private List<WebElement> productsNames;
	
	
	
	public orderpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	
	public boolean VerifyorderDisplay(String productname)
	{
		boolean match= productsNames.stream().anyMatch(cardproduct->cardproduct.getText().equalsIgnoreCase(productname));
		return match;
	}
	

	
}
