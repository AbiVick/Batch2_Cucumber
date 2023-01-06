package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() throws Exception {

		FileInputStream fis = new FileInputStream(".\\testData\\config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getAppURL() {

		return prop.getProperty("app_url_QA");

	}

	public String getBrowser() {

		return prop.getProperty("browser");

	}

	public String getSampleApp() {

		return prop.getProperty("app_SampleApp");

	}
	
	
	public String getadminUser() {

		return prop.getProperty("adminUserName");

	}
	
	public String getadminPass() {

		return prop.getProperty("adminPassword");

	}

}
