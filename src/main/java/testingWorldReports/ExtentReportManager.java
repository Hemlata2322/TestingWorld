package testingWorldReports;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports initiateExtentReport(Class<?> testClass) {
		extent = new ExtentReports();
		String className = testClass.getSimpleName();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String filePath = Paths
				.get(System.getProperty("user.dir") + "./TestReports/Extent-Report-" + className +timeStamp+ ".html").toString();
		ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
		extent.attachReporter(spark);
		return extent;
	}

	public static ExtentTest startTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	//No extra benifit can use test.pass directly along with customized message
	public static void logTestResult(String result) {
		switch (result.toUpperCase()) {
		case "PASS":
			test.pass("Test Passed");
			break;
		case "FAIL":
			test.fail("Test Failed");
			break;
		case "SKIP":
			test.skip("Test Skipped");
			break;
		default:
			test.info("Test Status Unkown");
		}
	}

	public static void attachScreenshot(String screenshotPath) {
		test.addScreenCaptureFromPath(screenshotPath);
	}
	public static void flushReport()
	{
		extent.flush();
	}
}
