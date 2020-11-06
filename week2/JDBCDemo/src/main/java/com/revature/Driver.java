package com.revature;

import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeService es = new EmployeeService();
		
		// This will return all of the Employee objects within our database
		List<Employee> list = es.findAll();
		
		for(Employee e: list) {
			System.out.println(e);
		}
		
		Employee bob = new Employee("Bob", "Smithers", "bs@gmail.com", 20000.05, null);
		es.addEmployee(bob);
		
		

	}
	
//	static void run() {
//		Scanner in = new Scanner(System.in);
//		String userInput;
//		
//		// Welcome Message
//		System.out.println("Welcome to your online banking application!\n " 
//		+ "\nDo you have an existing account? [y/n]");
//		userInput = in.nextLine();
//		if (userInput.equalsIgnoreCase("y")) {
//			// LOGIN
//			
//		} else {
//			// CREATE A USER
//		}
//	}

	
	
	
	
	
}
