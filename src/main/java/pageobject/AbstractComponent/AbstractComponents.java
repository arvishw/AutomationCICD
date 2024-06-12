package pageobject.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.cartpage;
import pageobject.orderpage;

public class AbstractComponents {
   WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderheader;

	public void waitfortheelementtoAppear(By findBy)
	
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
public void waitforwebelementtoAppear(WebElement findBy)
	
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException 
	
	{
		Thread.sleep(3000);
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 //wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public cartpage gotocartpage()
	{
		cartheader.click();
		cartpage crt=new cartpage(driver);
		return crt;
	}
	
	public orderpage gotorderpage()
	{
		orderheader.click();
		orderpage ord=new orderpage(driver);
		return ord;
	}
	
}
