package testingWorldUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
	
	public static String readConfigProperties(String key)
	{
		String filePath = "src/main/resources/config.properties";
		Properties prop = new Properties();
		try {
		FileInputStream fis = new FileInputStream(filePath);		
			prop.load(fis);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
