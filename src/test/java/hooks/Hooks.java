package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.utils.ExtentReportHelper;

public class Hooks {
    @Before
    public void setup() {
        ExtentReportHelper.initialiseReport();
    }

    @After
    public void tearDown() {
        ExtentReportHelper.flushReport();
    }

}
