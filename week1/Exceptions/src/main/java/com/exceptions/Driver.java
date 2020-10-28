package com.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

// An exception is an event that occurs during the execution
// of a program that disrupts the flow of an app
public class Driver {

	public static void main(String[] args) {
		
//		int x = 20;
//		int y = 0;
		
//		System.out.println(divideEAFP(x, y));
		//System.out.println(divideLBYL(x, y));
		//System.out.println(divide(x, y));
		
		int x = getIntEAFP();
		int y = getIntEAFP();
		
		System.out.println(divideEAFP(x, y));
	}
	
	// Look Before You Leap - LBYL
	// Easier to Ask for Forgiveness than Permission - EAFP
	private static int divideEAFP(int x, int y) {
		try {
			return x/y;
		} catch (ArithmeticException e) {
			return 0;
		}
	}
	
	
	private static int divideLBYL(int x, int y) {
		if (y != 0) {
			return x/y;
		} else {
			return 0;
		}
	}
	
	
	private static int divide(int x, int y) {
		return x/y;
	}
	
	private static int getInt() {
		Scanner input = new Scanner(System.in);
		boolean isValid = true;
		System.out.println("Please enter an integer:");
		String userInput = input.nextLine();
		
		for(int i=0; i<userInput.length(); i++) {
			if(!Character.isDigit(userInput.charAt(i))) {
				isValid = false;
				break;
			}
		}
		if(isValid) {
			return Integer.parseInt(userInput);
		}
		return 0;
	}
	
	// this is an unchecked exception that we're handling
	private static int getIntEAFP() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
		
		try {
			return input.nextInt();
		} catch (InputMismatchException e) {
			return 0;
		}
	}
	

	
	
	
 	
}
