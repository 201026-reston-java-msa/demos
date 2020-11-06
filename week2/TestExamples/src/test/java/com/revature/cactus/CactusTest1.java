package com.revature.cactus;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.Cactus;
import com.revature.Flower;

public class CactusTest1 {

	private static Cactus cactus;
	
	@Before
	public void setUp() throws Exception {
		List<Flower> startingFlowers = new ArrayList<Flower>();
		startingFlowers.add(Flower.Sunflower);
		cactus = new Cactus(10, 2, "Green", startingFlowers);
		
	}
	
	@Test
	public void testAddFlower() {
		// our cactus has a Sunflower..
		// by the end of the test, we want to ASSERTEQUALS
		// that we have both a sunflower and a bud
		cactus.addFlower(Flower.Bud);
		
		List<Flower> myCactusFlowers = new ArrayList<Flower>();
		myCactusFlowers.add(Flower.Sunflower);
		myCactusFlowers.add(Flower.Bud);
		
		assertEquals(myCactusFlowers, cactus.getFlowers()); 
	}
	
	@Test
	public void testRemoveFlower() {
		List<Flower> expected = new ArrayList<Flower>();
		// expected list.size == 0;
		
		cactus.removeFlower(Flower.Sunflower);
		// now cactus.flowers.size == 0....
		
		assertEquals(expected, cactus.getFlowers()); // 0 & 0
	}
	
	
	// This tests that we indeed CANNOT pass negative values in because otherwis
	// we'll throw the exception as we defined in our method body
	@Test(expected = IllegalArgumentException.class)
	public void testGrowException() {
		cactus.grow(-3.0);
	}
	
	@Test
	public void testSeeding() {
		List<Flower> childFlowers = new ArrayList<Flower>();
		childFlowers.add(Flower.Sunflower);
		
		// the expected baby Cactus object to return
		Cactus expected = new Cactus(0.1, 0.2, cactus.getColor(), childFlowers);
		
		assertEquals(expected, cactus.seeding());
		// That when you create tests that COMPARE OBJECTS
		// YOU MUST OVERRIDE THE .EQUALS() METHOD!!
	}
	
	@Test
	public void testBloom() {
		// we are only testing the int value that is returned from the bloom();
		assertEquals(1, cactus.bloom());
	}
	
// DONT'T WORRY ABOUT THIS
	
//	static boolean testDoubleEquality(Double one, Double two, Double delta){
//        return Math.abs(one - two)< delta;
//    }
//	
//	public static void main(String[] args) {
//		System.out.println(testDoubleEquality((double) 101, cactus.grow(100), 1.0));
//	}
//	
//	@Test
//	public void testGrowReturn() {
//		
//		
//		assertEquals(new Double(101), new Double(cactus.grow(100)));
//	}
	
	
	
	
}
