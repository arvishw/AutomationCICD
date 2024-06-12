package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobject.AbstractComponent.AbstractComponents;

public class landingppage extends AbstractComponents {

	WebDriver driver;
	
	public landingppage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//driver.findElement(By.id("userEmail")).sendKeys("artesting98@gmail.com");
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword")).sendKeys("Extra@12");
	
	
	@FindBy(id="userPassword")
	WebElement password;
	
	//   driver.findElement(By.id("login")).click();  
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	
	public productcatalog loginapplication(String email,String pwd)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		productcatalog pc=new productcatalog(driver);
		return pc;
	}
	
	public void GOto()
	
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String geterromessageforlogin()
	{
		waitforwebelementtoAppear(errormessage);
	return	errormessage.getText();
	}
}
