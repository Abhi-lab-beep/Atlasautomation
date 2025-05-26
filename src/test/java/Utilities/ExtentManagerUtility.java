package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testbase.testbase;



public class ExtentManagerUtility implements ITestListener {

    private ExtentSparkReporter sparker;
    private ExtentReports extent;
    private ExtentTest test;

    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report-" + timestamp + ".html";

        sparker = new ExtentSparkReporter(".\\Reports\\" + repName);
        sparker.config().setDocumentTitle("ATLS Automation Report");
        sparker.config().setReportName("ATLS Functional Testing");
        sparker.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparker);
        extent.setSystemInfo("Application", "Atlas");
       /* extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");*/

        String OS = context.getCurrentXmlTest().getParameter("OS");
        extent.setSystemInfo("Operating System", OS);

        String browser = context.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser Name", browser); // Fixed incorrect assignment

        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " successfully executed.");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " test failed.");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            String imgPath = testbase.captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Screenshot capture failed: " + e.getMessage());
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " test skipped.");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
