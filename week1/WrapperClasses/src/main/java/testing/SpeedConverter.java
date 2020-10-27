package testing;

public class SpeedConverter {

	//in this class I have a special method that converts kilometers per hour to miles per hour
	public static long toMilesPerHour(double kilometersPerHour) {
		
		return Math.round(kilometersPerHour/1.609);
		
	}
	
	public static int add(int x, int y) {
		return x +y;
	}

}
