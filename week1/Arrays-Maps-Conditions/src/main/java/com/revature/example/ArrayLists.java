package com.revature.example;

import java.util.ArrayList;

public class ArrayLists {

	public static void main(String[] args) {
		/*
		 * In addition to arrays Java provides ArrayLists
		 * This is a data type that automatically grows and shrinks
		 * an underlting array, so you're not locked into using an array
		 * of a predetermined size.
		 */
		
		// ArrayLists are objects, so you instantiate them using constructors
		ArrayList<String> triumvers = new ArrayList<String>();
		
		triumvers.add("Julius Caeser");
		triumvers.add("Cassius");
		triumvers.add("Pompeius");
		
		// to retrieve objects from an ArrayList, use the .get() method.
		System.out.println(triumvers.get(1));
	
		System.out.println(triumvers);
		
		// System.out.println(triumvers.remove(0));
		
		triumvers.add("Brutus");
		
		System.out.println(triumvers);
		
		triumvers.set(0, "Juliu$ Seiza");
		
		System.out.println(triumvers);
		
	}

}
