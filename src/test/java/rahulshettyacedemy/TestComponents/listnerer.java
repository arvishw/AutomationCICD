package rahulshettyacedemy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacedemy.resorces.extendreportng;

public class listnerer extends basetest implements ITestListener {

	ExtentReports extr=extendreportng.getReporteObject();
   ExtentTest test;
   ThreadLocal<ExtentTest > extentTest=new ThreadLocal<ExtentTest>();
   
	@Override
	public void onTestStart(ITestResult result) {
		
		test=extr.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	

	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");

	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	//test.fail(result.getThrowable());
	extentTest.get().fail(result.getThrowable());
	
	try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	String filepath = null;
	try {
		filepath = getScreenShot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	
	}
	
	
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println("Method skipped"+ result.getName());

	}
	
	@Override
	public void onFinish(ITestContext contextFinish) {
	extr.flush();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	System.out.println("Method failed with certain success percentage"+ result.getName());

	}

	

	

	

	

}
