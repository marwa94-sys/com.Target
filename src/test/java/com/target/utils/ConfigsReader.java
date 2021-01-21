package com.target.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigsReader {
	
	public static Properties prop;
	/**
	 * This folder reads an external file (.properties file)
	 * @param filePath : The path to our .properties file
	 */
	public static void readProperties(String filePath) {
		
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop= new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	

		
	
		
		
			
		
	}
		
		/**
		 * This method will read a value from properties file 
		 * @param key: key must be passed to this method
		 * @return: This method retuns the value of the key in the form of string
		 */
		
		public static String getProperty(String key) {
			return prop.getProperty(key);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


}
