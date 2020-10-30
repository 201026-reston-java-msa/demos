package com.designpatterns;
// Creational design patterns...
// Design Patterns were coined by a group of devs called the Gang of Four
public class Singleton {

	/*
	 * Sometimes we only need ONE instance of a class
	 * Fo example a single DB connection is an example of a singlton pattern
	 * Then that object would be shared by multiple objects
	 * as creating a separate DB connection for every object may be costly.
	 */
	
	/*
	 * Singleton Implementation:
	 * -- private constructor
	 * -- public method for returng the instance
	 * -- we use the getInstance() method so that we can get the only object available
	 */
	
	// private static field
	private static Singleton instance = null;
	
	// private constructor
	private Singleton() {
		
	}
	
	// static method
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
