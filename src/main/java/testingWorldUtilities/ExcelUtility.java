package testingWorldUtilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
	@DataProvider(name = "loginTestData")
	public static Object[][] readData()
	{
		File file = new File("./TestData/TestData.xlsx");
		try
		{
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sh = wk.getSheet("UserLoginTestData");
		
		int rows = sh.getPhysicalNumberOfRows();
		int cols = sh.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] testData = new Object[rows-1][cols];
		
		for(int i=1; i< rows; i++)
		{
			for(int j=0; j< cols; j++)
			{
				testData[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return testData;
		}
		catch(Exception e)
		{
			
		}
		return null;
		
	}

}
