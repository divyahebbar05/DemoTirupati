package campaigntest.TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import templates.resources.ExtentReporterNG;


//177

public class Listeners extends BaseTest4 implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent=	 ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal(); //179 using this line bcz test is only one variable used by all class at a time, hence it will messup reports, if we use this it will not override
	
	 @Override
	    public void onTestStart(ITestResult result) {
	
		test= extent.createTest(result.getMethod().getMethodName());
	        System.out.println("Test Started: " + result.getName());
	        extentTest.set(test); //it will assign unique thread id
	    }
	    
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test Passed: " + result.getName());
	    //    test.log(Status.PASS, "Test Passed");
	        extentTest.get().log(Status.PASS, "Test Passed"); //179
	    }
	    
	    
	    //178
	    @Override
	    public void onTestFailure(ITestResult result) {
	    	//screenshot
	        System.out.println("Test Failed: " + result.getName());
	        //test.log(Status.FAIL, "Test Failed");
	       // test.fail(result.getThrowable());
	        extentTest.get().fail(result.getThrowable()); //179
	        
	        try {
				driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //try catch automatically generated
			}
	    String filePath = null;   //from 42 to 48 it will implement 
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       // test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		 extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName()); //179
	    }
	    
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	    }
	    
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        System.out.println("Test Failed but within success percentage: " + result.getName());
	    }
	    
	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Test Execution Started: " + context.getName());
	    }
	    
	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("Test Execution Finished: " + context.getName());
	        extent.flush();

}
}
