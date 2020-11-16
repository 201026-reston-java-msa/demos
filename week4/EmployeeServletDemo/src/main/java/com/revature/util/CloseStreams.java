package com.revature.util;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class CloseStreams {
	
	// This should apply this to any resource such as a Scanner, Connection, or Statement

	public static void close(Statement c) {
		try {
			c.close();
		} catch (Exception e) {
		}
	}
	
	public static void close(Connection c) {
		try {
			c.close();
		} catch (Exception e) {
		}
	}
	
	public static void close(Scanner c) {
		try {
			c.close();
		} catch (Exception e) {
		}
	}
	
	
	public static void close(Closeable c) {
		try {
			c.close();
		} catch (Exception e) {
		}
	}
	

	
	

}
