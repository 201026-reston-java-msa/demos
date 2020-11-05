package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	
	private static Logger log = Logger.getLogger(ConnectionUtil.class);
	
	public static Connection getConnection() {
		
		/*
		 * This URL includes the driver we're using, which is from Postgres
		 * as well as the computer (which is localhost) and the PORT 
		 * which is 5432 by default
		 * 
		 * the last '/' is important because it refers to the specific db we're connecting to
		 * (If you only have one DB, you don't need to specify).
		 */
		
		// This is not secure!
//		String url = "jdbc:postgresql://localhost:5432/";
//		String username = "postgres";
//		String password = "postgres";
	
		
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			// this is more secure as you don't expose all your credentials
			prop.load(new FileReader("C:\\Users\\SophieGavrila\\Desktop\\demos\\week2\\JDBCDemo\\src\\main\\resources\\application.properties"));
			
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password")
					);
		} catch (SQLException e) {
			log.warn("Unable to obtain connection to database", e);
		} catch (FileNotFoundException e) {
			log.warn("Cannot locate properties file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	

}
