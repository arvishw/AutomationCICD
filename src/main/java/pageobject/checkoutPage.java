package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageobject.AbstractComponent.AbstractComponents;

public class checkoutPage extends AbstractComponents {

	WebDriver driver;
	
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".action__submit")
    WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
     WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
   public void selectCountry(String countryName)
   {
	   
	   Actions act=new Actions(driver);
	    act.sendKeys(country, countryName).build().perform();
	    
	    waitfortheelementtoAppear(By.cssSelector(".ta-results"));
	    selectCountry.click();
	    
	    
	  
	    
   }
   
   public confirmationpage submitOrders()
	  {
	   submit.click();
	   return new  confirmationpage(driver);
	  }
}
