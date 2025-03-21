package hooks;

import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Base;
import utils.ExtentReportHelper;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends Base {
    @Before
    public void setup(Scenario scenario) {
        ExtentReportHelper.initialiseReport();
        ExtentReportHelper.onStartTestReport("Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            ExtentReportHelper.logStep(Status.FAIL, "Scenario Failed: " + scenario.getName());
            final byte [] screenshotBytes = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png","img_ " + timestamp + " .png");
        } else {
            ExtentReportHelper.logStep(Status.PASS, "Scenario Passed: " + scenario.getName());
        }
        ExtentReportHelper.flushReport();
        Base.quitDriver();
    }


}
