package testingWorldTestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import testingWorldReports.ExtentReportManager;
import testingWorldUtilities.ScreenshotUtility;

public class BaseTest {
	public WebDriver driver;
	ITestResult result;
	
	@BeforeClass
	public void beforeClassSetup()
	{
		ExtentReportManager.initiateExtentReport(this.getClass());
	}
	@BeforeMethod
    public void setUp() {
        // Initialize WebDriver (Chrome)
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.thetestingworld.com/testings/");
        driver.manage().window().maximize();   
        
    }

    @AfterMethod
    public void tearDown() {
    	ScreenshotUtility.captureScreenshot(driver);
       driver.quit();
    }
    @AfterClass
    public void afterClasstearDown()
    {
    	ExtentReportManager.flushReport();	
    }

}
