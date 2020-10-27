package interfaces;

// Abstract classes CANNOT be instantiated
// Their sole purpose is to provide a template of common properties and some methods
public abstract class Animal { // Animal > Bird > Parrots	
	private String name;
	
	
	public Animal(String name) {
		this.name = name;
	}
	
	public abstract void eat();
	public abstract void breathe();

	public String getName() {
		return name;
	}

	
	

}
