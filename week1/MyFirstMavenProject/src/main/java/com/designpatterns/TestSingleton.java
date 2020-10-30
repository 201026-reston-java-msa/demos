package com.designpatterns;

public class TestSingleton {

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());

		// this proves that there may only be ONE Singleton object/instance
	}

}
