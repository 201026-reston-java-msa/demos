package inheritance;


public class Animal {
	
	private String name;
	private int brain; // this is their IQ
	private int size; 
	private int weight;
	
	public Animal(String name, int brain, int size, int weight) {
		this.name = name;
		this.brain = brain;
		this.size = size;
		this.weight = weight;
	}
	
	public void eat() {
		System.out.println("Animal.eat() has been called");
	}
	
	public void move() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBrain() {
		return brain;
	}

	public void setBrain(int brain) {
		this.brain = brain;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", brain=" + brain + ", size=" + size + ", weight=" + weight + "]";
	}

	
	
}
