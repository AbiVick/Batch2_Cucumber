package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadData {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream(".\\testData\\config.properties");
		
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		
		System.out.println(prop.getProperty("appURL"));
		System.out.println(prop.getProperty("userName"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("appURL_prod"));

	}

}
