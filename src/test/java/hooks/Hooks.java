package hooks;

import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Base;
import utils.ExtentReportHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        // Initialize ExtentReport and create a new test case for the scenario
        ExtentReportHelper.onStartTestReport("Scenario: " + scenario.getName());
        Base.logger.info("Test started: {}", scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Base.logger.error("Scenario failed: {}", scenario.getName());
            ExtentReportHelper.logStep(Status.FAIL, "Scenario Failed: " + scenario.getName());

            // Attach screenshot to the Cucumber report
            final byte[] screenshotBytes = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "FailedScreenshot");

            // Save screenshot using Base.takeScreenshot() and attach it to the ExtentReport
            String screenshotPath = Base.takeScreenshot();
            if (ExtentReportHelper.test != null) {
                ExtentReportHelper.test.addScreenCaptureFromPath(screenshotPath, "Failed Screenshot");
            }
        } else {
            ExtentReportHelper.logStep(Status.PASS, "Scenario Passed: " + scenario.getName());
            Base.logger.info("Scenario passed: {}", scenario.getName());
        }

        // Flush ExtentReports and quit WebDriver
        Base.reportFlush();
        Base.quitDriver();
    }
}
