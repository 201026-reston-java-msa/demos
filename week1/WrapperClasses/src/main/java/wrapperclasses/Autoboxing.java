package wrapperclasses;

import java.util.ArrayList;

public class Autoboxing {

	public static void main(String[] args) {
		char ch = 'b';
		
		// Autoboxing = primitive to Character object conversion
		Character b = ch;

		int x = 10;
		
		Integer num = x;
		
		// Why would I want to turn a primitive data type into an Object?
		// ...ArrayLists and Vectors store OBJECTS
		
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		
		myNumbers.add(100);
		myNumbers.add(42);
		
		System.out.println(myNumbers);
		
	}

}
