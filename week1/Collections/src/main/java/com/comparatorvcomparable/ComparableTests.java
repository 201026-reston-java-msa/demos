package com.comparatorvcomparable;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ComparableTests {
	
	// Java provides us with 2 interfaces to sort collections
	/*
	 * COMPARABLE - we use the comparable interface in tandem with a custom object that you're creating
	 * -- this controls HOW our objects are sorted...
	 * 
	 * COMPARATOR - .. TBA
	 */
	
	@Test
	public void test1(){
		
		Student stu1 = new Student();
		stu1.name = "Amy";
		stu1.grade = 45;
		
		Student stu2 = new Student();
		stu2.name = "Zayn";
		stu2.grade = 100;
		
		Student stu3 = new Student();
		stu3.name = "Rob";
		stu3.grade = 3;
		
		List<Student> students = new ArrayList<Student>();
		students.add(stu2);
		students.add(stu1);
		students.add(stu3);
		
		
		Collections.sort(students);
		
		System.out.println(students);
		
		// Challenge: how do you alter the compareTo method to sort by grade?
		
		assertEquals(students.get(0).getName(), "Rob");
		assertEquals(students.get(1).getName(), "Amy");
		assertEquals(students.get(2).getName(), "Zayn");
		
		
	}
	
	


}
