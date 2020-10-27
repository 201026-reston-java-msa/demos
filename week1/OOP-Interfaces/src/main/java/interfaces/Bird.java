package interfaces;

public abstract class Bird extends Animal {

	
	private String wingColor;

	public Bird(String name, String wingColor) {
		super(name);
		this.wingColor = wingColor;
	}

	@Override
	public void eat() {
		System.out.println(getName() + " is pecking");
		
	}
	
}
