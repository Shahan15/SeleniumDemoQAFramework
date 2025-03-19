package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions", //Specifies the package containing the step definitions.
        plugin = {"pretty", "html:src/main/resources/CucumberReports/cucumber-reports"}
        //this allows generation of reports
)

public class TestRunner extends AbstractTestNGCucumberTests {

}


//TestRunner is entry point for running feature files
//
