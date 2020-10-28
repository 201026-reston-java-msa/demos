package com.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UncheckedException {

	// the throws keyword in a method declares the type of exceptions that may occur
	// THROWS --> SENDS TO CALLER METHOD
	// THROW --> SENDS TO JVM
	public static void main(String[] args) {
		
		// this is an example of try with resources
		try {
			FileReader file = new FileReader("C:\\users\\downloads\\x.txt");
			BufferedReader fileInput = new BufferedReader(file);
			
			for (int i =0; i < 3; i++) {
				System.out.println(fileInput.readLine());
			}
			fileInput.close();
		} catch (IOException e) {
			// here's how we would recover
			System.out.println("File not found");
		} finally {
			System.out.println("This finally block will always run");

		}
		// IO is a Java API targeted for reading data from external sources

		
		// Print the first 3 lines of the file found at C:\\users\\downloads\\x.txt...
		
	}

}
