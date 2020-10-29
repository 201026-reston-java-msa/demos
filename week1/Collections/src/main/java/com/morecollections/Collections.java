package com.morecollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/*
 * We've already used the Collection framework quite a bit...
 * the root Interface of the Collection framework is ITERABLE
 * which allows data to be treaversed though (you can instantiate an iterator object)
 */

public class Collections {
	
	/*
	 * Both ArrayList and LinkedList extend from the LIST interface
	 * the only real difference is the underlying data structure
	 * 
	 * -- ArrayList is a resizeable array 0 default capacity is 10
	 * -- whereas a LinkedList stores data data in NODES in a doubly-linked list
	 */
	public static void main(String[] args) {
	
		// LIST allows duplicates
		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("there");
		words.add("10");
		
		words.remove(2);
		
		// it's faster to retrieve data from an arrayList than a linkedList
		String item = words.get(0);  // O(1) (faster than O(n))
		System.out.println(item);
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		// lists always maintain order of insertion
		for (int n : numbers) {
			System.out.println("The number is " + n);
		}
		// Linked lists are faster for insertion/deletion 
		// FIFO --> 
		numbers.remove();
		
		// Sets prevent duplicates from being added to it.....
		// Sets do not maintain the order of insertion
		HashSet<Integer> values = new HashSet<Integer>();
		values.add(12);
		values.add(23);
		values.add(4);
		values.add(12);
		
		for (int n : values) {
			System.out.println(n);
		}
		//LinkedHashSets maintain order
		
		HashSet<Person> people = new HashSet<Person>();
		Person p1 = new Person("Larry", 40);
		Person p2 = new Person("Mary", 23);
		Person p3 = new Person("Jerry", 90);
		Person p4 = new Person("Larry", 40);
		
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		
		// we have 2 objects with the SAME values...
		// are they considered duplicates? 
		
		for (Person person : people) {
			System.out.println(person);
		}
		
		// by overriding the .equals() method, we make it so that 2 instances that have the same field values
		// are considered EQUAL!
		
		
		// Queues --> First In First Out insertion policy. Dequeue's has a LIFO --> Last In First Out.
		
		/*
		 * The Collection Framework and the Collection Interface are NOT the same thing
		 * The Collection Framework encompassed Map, although java.util.Map does not implement 
		 * the Collection Interface...
		 * 
		 * Map is a PART of the Collection Framework, but NOT the java.lang.Collection Interface
		 */
		
		// HashMap: consists of Key/Value pairs and allows for 1 null value, and it's KEYS cannot be duplicated
		
		HashMap<String, String> dictionary = new HashMap<String, String>(); 
		dictionary.put("Brave", "ready to face danger");
		dictionary.put("Brilliant", "exceptionally clever");
		dictionary.put("Joy", "a feeling of great happiness");
		
		// to print out all KEYS:
		for (String key: dictionary.keySet()) {
			System.out.println(key);
		}
		System.out.println("-----------------------------------------");
		
		// to print out all the VALUES:
		for (String value: dictionary.keySet()) {
			System.out.println(dictionary.get(value));
		}
		System.out.println("------------------------------------------");		
		
		// print out both the keys AND values:
		for (Map.Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
