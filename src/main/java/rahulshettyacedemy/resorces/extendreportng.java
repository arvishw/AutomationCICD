package rahulshettyacedemy.resorces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendreportng {

	
	public static ExtentReports getReporteObject() 
	
	{
       String path=System.getProperty("user.dir")+"//reports//index.html";
		
		//ExtentHtmlReporter reporter=new ExtentHtmlReporter(path);
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extr=new ExtentReports ();
		extr.attachReporter(reporter);
		extr.setSystemInfo("Tester", "Arun Viswakarma");
		return extr;
		
		
	}
}
