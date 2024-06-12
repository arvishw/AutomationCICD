package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobject.AbstractComponent.AbstractComponents;

public class productcatalog extends AbstractComponents {

	WebDriver driver;
	
	public productcatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productby=By.cssSelector(".mb-3");
	
	By Addtocart=By.cssSelector(".card-body button:last-of-type");
	By toatmessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitfortheelementtoAppear(productby);
		return products;
	}
	
	public WebElement getProductName(String productName)
	{
		 WebElement prod= getProductList().stream().filter(product->
		    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		 return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		
	WebElement prod=getProductName(productName);
	prod.findElement(Addtocart).click();
	waitfortheelementtoAppear(toatmessage);
	waitForElementToDisappear(spinner);
	
	}
	
}
