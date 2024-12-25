package testingWorldUtilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ScreenshotUtility {
	static WebDriver driver;
	public static String captureScreenshot(WebDriver driver)
	{		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	//	String filePath = result.getTestName();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		File destFile = new File("./Screenshots/screenshotOnFailure"  + timeStamp + ".png");		
		try {
			FileUtils.copyFile(srcFile, destFile);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return destFile.getAbsolutePath();		
	}
	
	public static void captureScreenshotOnFailure(ITestResult result)
	{
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			String screenshotPath = captureScreenshot(driver);
			//return screenshotPath;
		}
	}

}
