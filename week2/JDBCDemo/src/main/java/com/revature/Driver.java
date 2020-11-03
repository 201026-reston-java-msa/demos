package com.revature;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		

	}
	
	static void run() {
		Scanner in = new Scanner(System.in);
		String userInput;
		
		// Welcome Message
		System.out.println("Welcome to your online banking application!\n " 
		+ "\nDo you have an existing account? [y/n]");
		userInput = in.nextLine();
		if (userInput.equalsIgnoreCase("y")) {
			// LOGIN
			
		} else {
			// CREATE A USER
		}
	}

	
	
	
	
	
}
