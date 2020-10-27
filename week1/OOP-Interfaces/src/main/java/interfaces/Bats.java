package interfaces;

public class Bats extends Animal implements Flyable{

	private int echolocationRange;

	public Bats(String name, int echolocationRange) {
		super(name);
		this.echolocationRange = echolocationRange;
	}


	public void fly() {
		System.out.println("the bat flaps its wings very fast");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		
	}

}
