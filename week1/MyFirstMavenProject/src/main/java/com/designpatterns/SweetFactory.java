package com.designpatterns;

public class SweetFactory {

	/*
	 * A factory design pattern is used to provide a class
	 * that returns a specific object for a user...
	 * 
	 * even though the precise type may not be known at runtime
	 * 
	 * In a factory pattern, we create an object without exposing the
	 * creation logic (abstraction)...so we use the COMMON INTERFACE to
	 * refer to the object
	 */
	
	/*
	 * to make a factory we use:
	 * 1. Abstract data type
	 * 2. Concrete Classes that inherit the abstract data type
	 * 3. A method that returns concrete instance (IN THE FACTORY! ((THIS)))
	 */
	
	// constructor
	public SweetFactory() {
		
	}
	
	public Sweets getSweets(String SweetType) {
		
		if(SweetType == null) {
			return null;
		} else if (SweetType.equalsIgnoreCase("hardcandy")) {
			return new HardCandy();
		} else if (SweetType.equalsIgnoreCase("marshmellow")) {
			return new Marshmellow();
		} else {
			return null;
		}
	}
	
	
}











