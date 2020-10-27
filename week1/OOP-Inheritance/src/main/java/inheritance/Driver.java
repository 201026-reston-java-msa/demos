package inheritance;

// Inheritance defines a relationship IS A relationship 
public class Driver {

	public static void main(String[] args) {
		Animal a = new Animal(null, 0, 0, 0);
		
		Dog d1 = new Dog("Yorkie", 1, 2, 13, 2, 4, 1, 20, "long silky");
		
		System.out.println(d1);
	}

}
