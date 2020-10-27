package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTestingService {
	
	
	private static final SpeedConverter mySpeedConverter = new SpeedConverter();
	
	@Test
	public void testSpeedConverter() {
		assertEquals(26, mySpeedConverter.toMilesPerHour(42));
	}
	
	@Test
	public void testAddition() {
		assertEquals(100, mySpeedConverter.add(30, 60));
	}

}
