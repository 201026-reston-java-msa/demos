package com.revature.unsolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// You will need to import the HashMap...

/* *************************************************************************** 
*
* To start, wrap your code in an infinite loop. What does this look like?
* 
*
*****************************************************************************/

/* *************************************************************************** 
*
* Next, create a map to store student information. Put the key/value pairs
*   as you collect information from the user.
*
*****************************************************************************/

public class Unsolved {

	public static void main(String[] args) {
		
	    // Wrap everything you have in an infinite loop.
	    
	    /* ************************************************************************
	     *
	     * Initialize the Scanner we'll need. 
	     *
	     *   You'll also want to create your student HashMap here. What key/value 
	     *   types do you use for it? 
	     *
	     *   Finally, initialize an ArrayList of students. Inside of the 
	     *   <Type Brackets>, put the type of the HashMap you created. This isn't
	     *   hard, but it will look weird.
	     *
	     *************************************************************************/
		
		Scanner input = new Scanner(System.in);
		ArrayList<HashMap<String, String>> students = new ArrayList<>();
		
		
		// ---- NAME INFORMATION ----
	
	while (true) {	
		
		// create a new HashMap for each student, for each iteration
		HashMap<String, String> student = new HashMap<>();
		
	    System.out.print("Please enter the student's first name. ");
	    if (input.hasNext()) {
	    	student.put("first", input.next());
	    }

	    System.out.print("Please enter the student's last name. ");
	    if (input.hasNext()) {
	    	student.put("last", input.next());
	    }

	    System.out.print("Please enter the student's middle initial. ");
	    String middleInitial = input.next();
	    input.nextLine(); // Strip the newline.

	    // ---- CONTACT INFORMATION ----
	    
	    System.out.print("Please enter the student's address. ");
	    String address = input.nextLine();

	    System.out.print("Please enter the student's email. ");
	    String email = input.next();

	    System.out.print("Please enter the student's phone number. ");
	    String phoneNumber = input.next();

	 // ---- PRINT  ----

	    /* Refactor this to print the value of each key iteratively. Use
	     *   String.format, and substitute the key/value names into the string.
	     */
	    
	   // Print the student's attributes
	   student.forEach((attribute, value) -> {;
	   System.out.println(String.format("The students %s id %s.", attribute, value));
	   });
	    

	    // Don't change this confirmation code just yet!
	    System.out.print("Is this information correct?");
	    String confirmation = input.next();

		}

	}
}
