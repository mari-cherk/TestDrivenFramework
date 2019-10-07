package comAnswerhubListener;

import com.relevantcodes.extentreports.LogStatus;
import comAnswerhubBace.TestBase;
import comAnswerhubUtilities.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {

        test = rep.startTest(iTestResult.getName().toUpperCase());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase()+" PASS");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase()+" Failed with exception : "+iTestResult.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));


        Reporter.log("Capturing screenshot");
        Reporter.log("<a target=\"blank\" href =" + TestUtil.screenshotName + ">ScreenShot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"blank\" href =" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName + " height=200></img></a>");

        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
