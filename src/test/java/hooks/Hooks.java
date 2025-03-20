package hooks;

import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.utils.Base;
import org.example.utils.ExtentReportHelper;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setup(Scenario scenario) {
        ExtentReportHelper.initialiseReport();
        ExtentReportHelper.onStartTestReport("Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportHelper.logStep(Status.FAIL, "Scenario Failed: " + scenario.getName());
        } else {
            ExtentReportHelper.logStep(Status.PASS, "Scenario Passed: " + scenario.getName());
        }
        ExtentReportHelper.flushReport();
        Base.quitDriver();
    }

}
