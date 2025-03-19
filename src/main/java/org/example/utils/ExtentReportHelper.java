package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportHelper {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void initialiseReport () {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("src/main/resources/Reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void flushReport() {
        extent.flush();
    }

}
