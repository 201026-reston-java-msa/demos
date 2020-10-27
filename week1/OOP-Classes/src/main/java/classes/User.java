package classes;

// the public class declaration creates a class which is an
// entity that can be instantiated

// a class is a blueprint for an object 
public class User {

	// these are PRIVATE so that nothing outside of the class can see/set it
	private String username;
	private String email;
	
	// This is a PRIVATE STATIC field which is a property
	/*
	 * we can see or modify inside the class, but which outsiders can't see (unless we let them)
	 */
	private static int usersCreated = 0;
	
	/*
	 * This is called a constructor...
	 * This is the method that's called whenever you
	 * create a new User, and is generally where we put our initialization logic.
	 */
	User(String username, String email) {
		this.username = username;
		this.email = email;
		
		User.usersCreated++ ; 
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + "]";
	}

	public void introduce() {
		System.out.println("Hello my username is " + this.username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static int getCount() {
		return User.usersCreated;
	}
}
