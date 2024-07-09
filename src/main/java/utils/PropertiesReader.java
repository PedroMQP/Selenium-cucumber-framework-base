package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	Properties prop;
	
	public PropertiesReader() {
		 try 
		 {
			 InputStream input = new FileInputStream("src/main/java/settings/testSettings.properties"); 
	         prop = new Properties();
	         prop.load(input);
	     } catch (IOException ex) {
	         ex.printStackTrace();
	     }
	}
	
	public String getURL() {
		return prop.getProperty("url");
	}
	
	public String getBrowser() {
		return prop.getProperty("defaultNavigator");
	}
}
