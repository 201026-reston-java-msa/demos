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
		
		System.out.println(User.getCount());
		
	}

}
