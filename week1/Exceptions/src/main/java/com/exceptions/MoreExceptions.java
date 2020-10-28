package com.exceptions;

public class MoreExceptions {

	public static void main(String[] args) {
		//System.out.println(practice());
		myMethod();
		
		System.out.println(withdraw(1000, 200)); // withdraw $200 from $1000
		
		System.out.println(withdraw(200, 1000)); // withdraw $1000 from $200
	}
	
	
	public static int practice() {
		try {
			return 1/0; // this will throw an ArithmeticException
		} catch (Exception e) {
			return 5;
		} finally {
			// System.exit(0); this wil shut down the application before
			// it reaches the finally block.
			// whatever code we write here is going to run...
			return 10;
		}
	}
	
	public static void myMethod() {
		try {
			//System.out.println(1/0); // This will throw Arith.Exception
			throw new ArithmeticException("Division by zero!"); // throw throws it to the JVM
		} catch(Exception e) {
			e.printStackTrace();
			// we can print the stack trace of the exception
			// this could potentially be the way we handle this exception
		}
		
		
		
	}
	
	
	public static double withdraw(double balance, double amountToWithdraw) {
		if (amountToWithdraw > balance) {
			throw new OverdraftException("Attempted to withdraw too many funds!");
		}
		
		System.out.println("We withdrew $" + amountToWithdraw);
		
		// add some logic to alter the properties of the object that the method's being called on
		//this.balance = balance - amountToWithdraw;
		
		double remainingBalance = balance - amountToWithdraw;
		return remainingBalance;
	}
	
	
	
	
	
	
	
	
	
}
