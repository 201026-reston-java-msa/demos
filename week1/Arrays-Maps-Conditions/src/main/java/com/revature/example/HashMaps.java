package com.revature.example;

import java.util.HashMap;

public class HashMaps {
	
	public static void main(String[] args) {
		
		/*
		 * Hashmaps:
		 * 
		 * When you define a HasMap, you need to declare
		 * a KEY and a corresponding VALUE
		 * If we want our keys to be employee's last name, and the value 
		 * to be their salary, we're have a HashMap with String keys and Integer values
		 * 
		 * int --> Integer
		 * boolean --> Boolean
		 * String --> String
		 */
		
		HashMap<String, Integer> payroll = new HashMap<String, Integer>();
		
		// to set a key's value
		payroll.put("Ceasar", 100000);
		
		// to retrieve the value of a key, use:
		System.out.println(payroll.get("Ceasar"));
		
		// use a method called getOrDefault to verify whether the key exists or not.
		System.out.println(payroll.getOrDefault("Brutus", 500));
		
		
		/*
		 * There are a couple ways to iterate over a Map
		 * 
		 */
		
		payroll.put("Pompeius", 75000);
		payroll.put("Brutus", 200000);
		
		payroll.forEach((name, salary) -> {
			System.out.println(String.format("%s's salary is %d", name, salary));
		});
		
	}
	

}
