package com.revature.examples;

import java.util.Scanner;

public class ConsoleIODemo {

	/*
	 * This is a multi-line comment.
	 */
	
	// This is the entry point of our application 
	public static void main(String[] args) {
			
	/*
	 * Java is statically (or strongly) typed therefore
	 * you must declare the type of data stored in a variable
	 */
		
		String name = "Cleopatra";
		int age = 2020 + 69;
		
	/*
	 * Another common number type is the double, which is a
	 * high precision floating point number.
	 */
	
		double price = 203.44;
		
	/*
	 * The other important type you should be aware of it boolean;
	 * This stores true or false values.
	 */
		
	boolean truth = true;
	boolean notTheTruth = !truth; // == false
	
	/*
	 * to print to stdout, use System.out.println
	 */
	
	System.out.println(String.format("%s is %d years old", name, age));
	
	// Create a Scanner that reads from the System's standard input stream.
	// From the Scanner class, we have instantiated a Scanner object.
	Scanner input = new Scanner(System.in);
	
	// For an entire sentence, use nextLine() method.
	System.out.println("Enter a sentence for me to read");
	String sentance = input.nextLine();
	
	// Collect a single word using the next() method.
	System.out.println("Enter a word for me to read...");
	String word = input.next();
	
	// For a whole number, use nextInt();
	System.out.println("Enter a number for me to read:");
	int integer = input.nextInt();
	
	// For a double, use nextDouble();
	System.out.println("Enter a double for me to read:");
	double dub = input.nextDouble();
	
	}

}










