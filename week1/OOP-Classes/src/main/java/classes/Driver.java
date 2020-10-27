package classes;

public class Driver {

	// we will instantiate an object from a User class here
	public static void main(String[] args) {
		// Since our User class is in the same package, there's no need to import that Class
		User tim = new User("Tim24", "tim@gmail.com");

		// System.out.println(tim);
		
		tim.introduce();
		
		System.out.println(tim.getEmail());
	
		User john = new User("John234", "john@gmail.com");
		
		System.out.println(User.getCount()); // This is an example of a Class (static) scope
		
		System.out.println(john.getEmail()); // This is an example of an Object (Instance) scope
		
		// I CANNOT access variable x from the add method....this is because its scope is a METHOD SCOPE
		// System.out.println(x); // will fail...
		
	}
	
	public static int add(int x, int y) {
		
		for (int i=0; i<10; i++) {
			x+=i; // variable is INACCESSIBLE - this is because it belongs to the block scope...
		}
		
		// System.out.println(i); // this will fail
		return x + y;
	}
	
}
