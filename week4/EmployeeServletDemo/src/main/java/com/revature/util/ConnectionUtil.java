package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	private static Logger log = Logger.getLogger(ConnectionUtil.class);
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			log.warn("Cannot load driver");
			e.printStackTrace();
		}
		
		Properties props = new Properties();
		// This isn't always necessary but this object will search for 
		//files within our current project - makes it a lot easier to specify where it's located
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Connection conn = null;
		try {
			props.load(loader.getResourceAsStream("connection.properties"));
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				log.warn("Unable to obtain connection to the database", e);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return conn;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
