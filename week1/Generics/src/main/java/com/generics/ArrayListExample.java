package com.generics;

import java.util.ArrayList;

/*
 * Generics allow us to create classes, interfaces, and methods
 * that take TYPE parameters
 */

public class ArrayListExample {

	public static void main(String[] args) {
		
		// this arraylist will accept integers
		ArrayList<Integer> items = new ArrayList<Integer>();
		// by parameterizing ArrayList with type Integer, I'm restricting
		// the data TYPE that's stored within it
		items.add(1);
		items.add(2);
		//items.add("word");
		items.add(3);
		items.add(4);
		
		printDoubled(items);
		
	}
	
	public static void printDoubled(ArrayList<Integer> arr) {
		for (int i : arr) {
			System.out.println(i * 2);
		}
	}
	
	
	
	
	
	
	
	
	

}
