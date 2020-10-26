package com.revature.example;

import java.util.Scanner;

public class Conditionals {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		
		// Let's set up conditional logic...
		/*
		 * If the number is less than 10, say too low.
		 * If the number is > 10 too high
		 * If the number is = 10, say perfect
		 */
//		if (num < 10) {
//			System.out.println("too low");
//		} else if ( num > 10) {
//			System.out.println("too high");
//		} else if (num == 10) {
//			System.out.println("perfect");
//		}
		
		System.out.println(Math.random() * 10); // Math.random() will return a double between 0.0 and 1.0
		// we must cast the double to an integer
		
		
		int randomNum = (int) (Math.random() * 10);
		System.out.println(randomNum);
		
		if (num == randomNum) {
			System.out.println("Correct guess");
		} else {
			System.out.println("Wrong guess");
		}
		
	}

}
