package rahulshettyacedemy.TestComponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.landingppage;

public class basetest {

	 public WebDriver driver;
	 public landingppage ldp;
	
	public WebDriver iniializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacedemy//resorces//GlobalData.properties");
		prop.load(fis);
		
		
		String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		//String BrowserName=prop.getProperty("browser");
		
		if(BrowserName.contains("chrome"))
		{
		ChromeOptions option=new ChromeOptions();
			
		WebDriverManager.chromedriver().setup();
		if(BrowserName.contains("headless")) {
			option.addArguments("headless");
		}
	    driver=new ChromeDriver(option);
	    driver.manage().window().setSize(new org.openqa.selenium.Dimension(1440,900));
	    
		} 
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		else if(BrowserName.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver","edge.exe");
			 driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5)); 
	    return driver;
	    
	}
	
    public List<HashMap<String, String>> getJsonDatatoMap(String filepath) throws IOException 
	
	{
		//read json to String
     String jsonContent=	FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);	
		//String to Hashmap jackson databind`

     ObjectMapper mapper=new ObjectMapper();
     
     List<HashMap<String,String>> data=   mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
     });
     
     return data;
	}
    
      public String getScreenShot(String testcaseName,WebDriver driver) throws IOException 
	
	{
		TakesScreenshot ts= (TakesScreenshot)driver;	
	    File souce=	ts.getScreenshotAs(OutputType.FILE);
	    File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
	    FileUtils.copyFile(souce, file);
	    return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	   
	
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public landingppage launchapplication() throws IOException
	{
		
	 driver=iniializeDriver();
	 ldp=new landingppage(driver);
	 ldp.GOto();  
	 return ldp;
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown()
	{
		driver.close();
	}
}
