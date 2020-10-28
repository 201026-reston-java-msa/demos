package com.revature.strings;

public class StringsDriver {

	public static void main(String[] args) {
		
		stringFun();
		
		// Java additionally has two classes similar to String: StringBuffer and String Builder
		// they are similar to Strings except that they can be modified..
		
		// StringBuilder is NOT threadsafe...but faster.
		// StringBuffer IS threadsafe...but slower.
		// a piece of code is thread-safe if it functions correctly during simultaneous execution
		// by multiple threads
		StringBuilder sb = new StringBuilder("Hello");
		sb.reverse();
		System.out.println(sb); // java.lang.Object
		// Note: when we we System.out.println it, we are invokeing the
		// toString(); method on the StringBuilder Object
		
		/*
		 * Make sure to check out some of the methods that can be performed on 
		 * StringBuffer and StringBuilder.
		 */
		

	}
	
	private static void stringFun() {
		
		// here we will create some strings and varibles
		// & compare both the VALUE and OBJECT ADDRESS (within the Heap > String Pool)
		
		String str1 = "hi"; // creates a new String in the String pool
		
		String str2 = "hi"; // str2 var now points to "hi" in the String pool
		// using the already existing String
		
		String str3 = new String("hi"); // the String is created OUTSIDE of the String pool
		
		// == will check to see if the reference variable refers to the SAME object..
		System.out.println(str1==str2);  // true
		System.out.println(str1==str3); // false
		
		// .equals() with Strings will check VALUE equality
		System.out.println(str1.equals(str2)); // true
		System.out.println(str1.equals(str3)); // true
		
		String test = "Here is my String -- isn't it cool?";
		//String str4 = test.replaceAll(" ", "_");
		//System.out.println(str4);
		System.out.println(test.charAt(2));
		
		// method chaining
		System.out.println(test
				.toUpperCase()
				.substring(5)
				.concat("concat     !")
				);
		
	}
	

	
	
	
	
	

}
