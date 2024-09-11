package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	private static Properties prop;                  // WE SAT THIS METHOD AS PRIVATE BECAUSE WE DONT WANT TO SHARE EVERYTHING WE HAVE IN CONFIGURATION.PROPERTIES
	                                                 // Thats why we also created another class called Constants. 

	/**
	 * This method reads the properties of a config file
	 * 
	 * @param filePath
	 */
	public static void readProperties(String filePath) {

		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method returns the value of the provided key in configs file
	 * 
	 * @param String key
	 * @return String value
	 */
	public static String getProperty(String key) {   // WE WROTE THIS CODE BECAUSE WE NEED A RETURN!
		return prop.getProperty(key);                //in the beginning we couldn't use the prop because it was inside the first method on top of the page.
		                                             // so we created the instance variable for prop inside the class but outside the method
		                                             // we created --> private static Properties prop;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

