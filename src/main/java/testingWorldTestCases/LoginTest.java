package testingWorldTestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import testingWorldReports.ExtentReportManager;
import testingWorldReports.LoggerManager;
import testingWorldTestBase.BaseTest;
import testingWorldUtilities.ExcelUtility;
import testingWorldUtilities.ScreenshotUtility;
import testingWorldWebPages.LoginWebPage;

public class LoginTest extends BaseTest {
	
	LoginWebPage _loginpage = new LoginWebPage();
	
	private ExtentTest test;
	ITestResult result;
	
	@Test(priority = 1, dataProvider = "loginTestData", dataProviderClass = ExcelUtility.class)
	
	public void validatingValidLogin(String userName, String password)
	{
				
	test = ExtentReportManager.startTest("Verifying valid login");
	try 
	{
	LoggerManager.log.info("Starting Valid login test");
	LoggerManager.log.info("Navigating to Login tab");
	
		
	_loginpage.switchingToLoginTab();
		test.info("Navigated to Login tab");
		LoggerManager.log.info("Entering username");
		_loginpage.enterUsername(userName);
		
		test.info("Entered username");
		LoggerManager.log.info("Entering valid password");
		_loginpage.enterPassword(password);
		
		test.info("Entered password");
		LoggerManager.log.info("Clicking on login button");
		_loginpage.clickOnLoginBtn();
		
		test.info("Clicked on login button");
		test.pass("Successfully logged in");
	}
	catch(Exception e)
	{
		LoggerManager.log.error("Failed to login due to exception occured" + e.getMessage());
		test.fail("Valid login test failed due to exception").addScreenCaptureFromPath(ScreenshotUtility.captureScreenshot(driver));
	}
	}
	@Test(enabled = true)
	public void validatingInvalidLogin()
	{
		test = ExtentReportManager.startTest("Verifying Invalid login");
		try 
		{
		LoggerManager.log.info("Starting InValid login test");
		LoggerManager.log.info("Navigating to Login tab");
			driver.findElement(By.xpath("//input[@id = 'tab2']/parent::li")).click();
			LoggerManager.log.info("Entering username");
			driver.findElement(By.name("_txtUserName")).sendKeys("Hems");
			LoggerManager.log.info("Entering invalid password");
			driver.findElement(By.name("_txtPassword")).sendKeys("Password");
			LoggerManager.log.info("Clicking on login button");
			driver.findElement(By.xpath("//input[@value = 'Login']")).click();	
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'tab1']/parent::li")).isDisplayed());
			test.pass("Navigated to sign up tab");
		}
		catch(Exception e)
		{
			LoggerManager.log.error("Failed to login due to exception occured" + e.getMessage());
			test.fail("InValid login test failed due to exception").addScreenCaptureFromPath(ScreenshotUtility.captureScreenshot(driver));
		}
	}

}
