package interfaces;

public class Parrot extends Bird implements Flyable {

	public Parrot(String name, String wingColor) {
		super(name, wingColor);
		// TODO Auto-generated constructor stub
	}

	public void fly() {
		System.out.println("It glides through the rainforest.");
		
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		
	}
	
	
}
