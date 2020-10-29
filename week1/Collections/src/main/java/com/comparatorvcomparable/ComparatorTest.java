package com.comparatorvcomparable;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ComparatorTest {
	
	@Test
	public void myTest() {
		
		String str1 = "tiger";
		String str2 = "Zoo";
		
		List<String> list = new ArrayList<String>();
		list.add(str1);
		list.add(str2);
		
		//Collections.sort(list);
		Collections.sort(list, new Comparator<String>() {

			public int compare(String o1, String o2) {
				
				return o1.compareToIgnoreCase(o2);
			}
		
		});
		/*
		 * An Inner class declared without a class name is known as an anonymous inner class...
		 * We declare and instantiate them at the same time...
		 * 
		 * THEY ARE USED WHENEVER YOU NEED TO OVERRIDE THE METHOD OF A CLASS OR INTERFACE!
		 */
		
		System.out.println(list);
		
		assertEquals(list.get(0), "tiger");
		assertEquals(list.get(1), "Zoo");
		
		
	}

}
