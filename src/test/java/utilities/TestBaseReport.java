package utilities;

import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.LocalTime;

public class TestBaseReport {

    @BeforeMethod
    void beforeMethod(Method method) {
        ExtentReportManager.createTest(this.getClass().getSimpleName());
        ExtentReportManager.log(Status.INFO, "Test started at: " + LocalTime.now());
    }

    @AfterMethod
    void tearDown(ITestResult result) {
        ExtentReportManager.log(Status.INFO, "Test finished at: " + LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
    }

}
