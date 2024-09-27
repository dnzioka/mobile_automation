package dominic.common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
    ExtentTest test;

    ExtentReports extent = ExtentManager.getReports();

    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test passes
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test fails
        // screenshots
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test is skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to execute when a test fails but is within the success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before any test starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after all tests finish
        extent.flush(); // This finalizes the report
    }

}
