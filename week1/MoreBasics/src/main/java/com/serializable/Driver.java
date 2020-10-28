package com.serializable;

import java.io.Serializable;

public class Driver {

	public static void main(String[] args) {

		// Serialization is the process of turning an object in memory
		// into a stream of bytes so you can do things like save
		// it on a disk or send it over a network...it's not only readable on the JVM anymore
		Serializable thingsToSave = new Sparrow("Red Sparrow", "Red", -2);		
		

	
	}

}
