package com.loggingpractice;

import org.apache.log4j.Logger;

public class Driver {
	
	private static final Logger log = Logger.getLogger(Driver.class);
	/// we use the .class property where there's not an INSTANCE
	// of the class available

	/*
	 * Logging is the process of writing log messages during the
	 * execution of a program to a central place
	 * 
	 * Logging allows you to report and persist error and warning messages
	 * as well as info messages - runtime statistics
	 * 
	 * Loggers are created with the getLogger method...
	 */
	
	/*
	 * There are different logging Levels:
	 * OFF: No logging at all
	 * ALL: Turns on all levels of logging
	 * TRACE: addd more info to debug level logs
	 * DEBUG: Basically for devs turns on all of the following levels in addition
	 * to DEBUG
	 * INFO: important business processes that have finieshed and good news
	 * is "as expected"
	 * -- system admins use this
	 * WARN: suggests that the application might be continued but you should take caution
	 * ERROR: shouts that something has gone very very wrong
	 * FATAL: Very uncommon but signals that something is catastrophically
	 * wrong and applicatino will fail
	 */	
	
	public static void main(String[] args) {
		
		log.info("PROGRAM START");
		
		try {
			int x = 1/0;
			log.info("Computation Successful");	
		} catch (ArithmeticException e) {
			log.warn("WARNING: Division by zero occured!", e);
		}

		log.info("PROGRAM END");

	}

}
