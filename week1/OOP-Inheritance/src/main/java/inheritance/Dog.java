package inheritance;

public class Dog extends Animal {

	private int eyes;
	private int legs;
	private int tail;
	private int teeth;
	private String coat;
	
	public Dog(String name, int brain, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
		super(name, brain, size, weight);
		this.eyes = eyes;
		this.legs = legs;
		this.tail = tail;
		this.teeth = teeth;
		this.coat = coat;
	}

	private void chew() {
		System.out.println("chew() has been called");
	}

	// This is an example of Polymorphism in which we are changing the behavior of a method on the object
	@Override
	public void eat() {
		System.out.println("Dog.eat() has been called");
		chew();
	}
	
	
	
	
	
}
