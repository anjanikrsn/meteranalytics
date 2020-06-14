package com.nitesh.meteranalytics.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	static Properties properties =new Properties();
	
	static {
		try(InputStream inputStream = PropertiesReader.class.getResourceAsStream("/db.properties");) {
			properties.load(inputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
	
	public static String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
}
