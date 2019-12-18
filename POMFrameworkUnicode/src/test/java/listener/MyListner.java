package listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListner implements ITestListener, ISuiteListener{

	
	public void onStart(ISuite suite) {

		System.out.println("Starting Test Suite- @BeforeSuite");
	}

	public void onFinish(ISuite suite) {

		System.out.println("Ending Test Suite- @AfterSuite");
	}

	
	public void onTestStart(ITestResult result) {

		System.out.println("@BeforeMethod");
	}

	
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Executed successfully...");
		Reporter.log("Test Executed successfully");
	}

	
	public void onTestFailure(ITestResult result) {

		System.out.println("Test Failure");
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		Reporter.log("<a target=\"_blank\" href=\"Bug1.jpg\">Error Occurred</a>");

		
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped Test");
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Test Starts- @BeforeTest");
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Test Ends- @AfterTest");
		
	}

}
