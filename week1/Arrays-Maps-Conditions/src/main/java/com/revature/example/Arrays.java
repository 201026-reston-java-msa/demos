package com.revature.example;

public class Arrays {

	public static void main(String[] args) {
		// Java allows you to use arrays and ArrayLists
		// arrays will store data of a single type
		
		// to intiialize an array we do the following:
		// this creates just an array of strings called names....
		String[] names;
		
		//This initializes a new array with 3 slots....
		names = new String[3];
		
		// If you know what values you want to insert in the array, you can create
		// the array and fill it in all at once
		String[] triumvers = {"Julius", "Cassius", "Pompeius"};
		
		// Otherwise, we could values by indicating the particular index and assigning it.
		names[0] = "Julius";
		names[1] = "Cassius";
		names[2] = "Pompeius";
		
		// to iterate over an array, we use a for loop
		// a for loop consists of the beginning, the termination point, and the incrementation
		for (int i=0; i < triumvers.length; i+= 1) {
			System.out.println("The ruler's name is: " + triumvers[i]);
		}
		
		// Enhanced for-loop: (or a for-each loop) 
		for (String x : triumvers) {
			System.out.println("Within the enhanced for-loop, the name is: " + x);
		}
	
	}

}
