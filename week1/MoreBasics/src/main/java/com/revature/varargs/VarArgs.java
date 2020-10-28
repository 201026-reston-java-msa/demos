package com.revature.varargs;

public class VarArgs {

	public static void main(String[] args) {
		
		System.out.println(add(2, 100));
		System.out.println(add(2, 100, 200));
		System.out.println(add(1, 2, 3, 4, 5, 6, 700, 800, 9000));
		

	}
	
	public static int add(int x, int y) {
		return x +y;
	}
	
	// this is overload -- which is an example of Polymorphism
	public static int add(int x, int y, int z) {
		return x + y + z;
	}
	
	// VarArgs however, allows for a single method defintiion
	// to support ANY NUMBER of parameters...
	// the parameters in a method that supports VarArgs converts them to an array...
	public static int add(int...nums) { // String array + any primitive datatype
		// we will return the sum of all of the parameters passed:
		int sum=0;
		
		for (int n : nums) {
			//sum = sum + n; this is the longer way of writing it out...
			sum += n;
		}
		
		return sum;
	}
	
	

}
