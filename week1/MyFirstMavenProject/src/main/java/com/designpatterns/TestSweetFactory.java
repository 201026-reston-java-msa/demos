package com.designpatterns;

public class TestSweetFactory {

	public static void main(String[] args) {
		// Use the factory to get an object of concrete class
		// by passing an information such as TYPE

		new SweetFactory().getSweets("hardcandy").bake();
		new SweetFactory().getSweets("marshmellow").bake();
		
		new SweetFactory().getSweets("hardycandy");
		
		
	}

}
