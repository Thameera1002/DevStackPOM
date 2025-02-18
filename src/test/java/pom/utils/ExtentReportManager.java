package pom.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentTest test;

    public static void setupReport(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Search Item Report");
        sparkReporter.config().setReportName("Search Item Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void startTest(String testName){
        if(extent==null){
            setupReport();
        }
        test = extent.createTest(testName);
    }

    public static void passLog(String message){
        if(test!=null){
            test.pass(message);
        }
    }

    public static void failLog(String message){
        if(test!=null){
            test.fail(message);
        }
    }

    public static void endTest(){
        if(extent!=null){
            extent.flush();
        }
    }

    public static void writeToReport(String text){
        if(test!=null){
            test.pass(text);
        }
    }
}
