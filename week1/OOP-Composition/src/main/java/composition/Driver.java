package composition;

public class Driver {

	public static void main(String[] args) {
		
		Motherboard theMotherboard = new Motherboard("BX-200", "Asus", 4, 6, "dual-bios");
		
		Monitor theMonitor = new Monitor("The Beast", "Acer", 48, new Resolution(2540, 1440));

		Dimensions dimensions = new Dimensions(20, 5, 20);
		Case theCase = new Case("AX-20", "Dell", "240", dimensions);
		
		// This is an example of a HAS A relationship
		PC thePC = new PC(theCase, theMonitor, theMotherboard);
		thePC.getMonitor().drawPixelAt(1500, 1200, "yellow");
		thePC.getMotherboard().loadProgram("Windows 10");
		thePC.getTheCase().pressPowerButton();
		
		
	}

}
