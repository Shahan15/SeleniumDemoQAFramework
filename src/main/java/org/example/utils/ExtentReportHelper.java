package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

public class ExtentReportHelper {
    public static ExtentReports extent;
    public static ExtentTest test;
    private static String SSPath = Base.takeScreenshot();

    public static void initialiseReport () {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("src/main/resources/Reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void onStartTestReport (String testName) {
        test = extent.createTest(testName);
    }

    public static void logStep(Status status,String details) {
        if (test !=null) {
            test.log(status,details);
        }
    }

    public static void onTestFail (Scenario scenario) {
        if (test != null) {
            ExtentReportHelper.logStep(Status.FAIL, "Scenario Failed: " + scenario.getName());
            try {
                test.addScreenCaptureFromPath(SSPath);
            } catch (Exception e) {
                Base.logger.error("Error capturing screenshot:{}", e.getMessage());
            }
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}

