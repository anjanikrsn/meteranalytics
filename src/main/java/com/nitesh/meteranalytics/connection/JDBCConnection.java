package com.nitesh.meteranalytics.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.nitesh.meteranalytics.properties.PropertiesReader;

public class JDBCConnection {
	
	private static volatile Connection instance = null;
	
	private JDBCConnection() {
		
	}
	
	public static Connection getConnection() {
		if(instance == null) {
			synchronized(JDBCConnection.class) {
				if(instance == null) {
					try {
					//Class.forName(PropertiesReader.getProperty("jdbc.driver"));
			        instance = DriverManager.getConnection(PropertiesReader.getProperty("jdbc.url"),
			        		PropertiesReader.getProperty("jdbc.user"),
			        		PropertiesReader.getProperty("jdbc.password"));
					}catch( SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return instance;
	}
}
