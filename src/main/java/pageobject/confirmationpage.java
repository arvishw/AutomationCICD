package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobject.AbstractComponent.AbstractComponents;

public class confirmationpage extends AbstractComponents {
	WebDriver driver;
	public confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(css=".hero-primary")
    WebElement confimmessage;
	
	public String getconfirmationmessage() {
		return confimmessage.getText();
		
		
	}
}
