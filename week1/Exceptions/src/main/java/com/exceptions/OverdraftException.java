package com.exceptions;

public class OverdraftException extends RuntimeException{
	
	public OverdraftException() {
		super();
	}
	
	// This is overloading the constructor
	public OverdraftException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public OverdraftException(String message) { 
		super(message);
	}
	
	public OverdraftException(Throwable cause) {
		super(cause);
	}

}
