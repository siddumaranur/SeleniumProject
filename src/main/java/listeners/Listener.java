package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listener extends Base implements ITestListener {

	ExtentReports extentReport=ExtentReporter.getExtentReport();
	ThreadLocal<ExtentTest> extentTestThread =new ThreadLocal<ExtentTest>();
	ExtentTest extentTest;
	WebDriver driver = null;
	@Override
	public void onTestStart(ITestResult result) {

		String testName=result.getName();

		 extentTest=extentReport.createTest(testName+" execution started");
		 extentTestThread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName=result.getName();
       // extentTest.log(Status.PASS,testName+ "got Passed");
		extentTestThread.get().log(Status.PASS,testName+" "+ "got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

     String testMethodName=result.getName();
     extentTestThread.get().fail(result.getThrowable());
     
    try {
		 driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
    	
    	//Adding Screenshot in to extentreport
		String ScreenshotFilePath=takeScreenshot(testMethodName,driver);
		extentTestThread.get().addScreenCaptureFromPath(ScreenshotFilePath, testMethodName);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {


	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {


	}

	@Override
	public void onStart(ITestContext context) {


	}

	@Override
	public void onFinish(ITestContext context) {


		extentReport.flush();
		
	}
	

}
