package revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	
	private static Logger log = Logger.getLogger(ConnectionFactory.class);
	
	public static Connection getConnection() {
		
		/*
		 * This URL includes the driver we're using, which is from Postgres
		 * as well as the computer (which is localhost) and the PORT 
		 * which is 5432 by default
		 * 
		 * the last '/' is important becauase it refers to the specific db we're connecting to
		 * (If you only have one DB, you don't need to specify).
		 */
		
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=chinook";
		String username = "postgres";
		String password = "postgres";
		
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			log.warn("Unable to obtain connection to database", e);
		}
		
		return conn;
	}
	

}

