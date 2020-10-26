package com.revature.solved;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		// 1. Initialize a Scanner
		Scanner input = new Scanner(System.in);
		
		// 2.  Collect student name information.
		System.out.println("Please enter the student's first name:");
		String firstName = input.next();
		
		System.out.println("Please enter the student's last name:");
		String lastName = input.next();
		
		System.out.println("Please enter the student's middle intial:");
		String middle = input.next();
		
		input.nextLine(); // Strip the new line.
		
		//3.  Collect student contact info:
		System.out.println("Please enter the student's address:");
		String address = input.nextLine();

		System.out.println("Please enter the student's email:");
		String email = input.next();
		
	    System.out.print("Please enter the student's phone number. ");
	    String phoneNumber = input.next();
	    
	    // Print user-input values:
	    System.out.println(String.format("The student's full name is %s %s", firstName, lastName));
	    
	    System.out.println("The student's full name is " + firstName + " " + middle + " " + lastName);
		
	    System.out.println(
	            String.format("The student's address is %s. ", address));

	        System.out.println(
	            String.format("The student's email is %s. ", email));

	        System.out.println(
	            String.format("The student's phone number is %s. ", phoneNumber));
	    
	    // Confirm if info is correct!
	    System.out.println("is the above information correct?");
	    String confirmation = input.next();
	}

}
