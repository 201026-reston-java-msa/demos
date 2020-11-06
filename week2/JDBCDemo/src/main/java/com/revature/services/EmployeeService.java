package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

// since services acts as another level ontop of your DAO,
// you must instantiate a repository object
public class EmployeeService {
	
	EmployeeDAO repository = null;
	
	public EmployeeService() {
		repository = new EmployeeDAOImpl();
	}
	
	/**
	 * This is a very simple method.  It doens't add any extra logic.
	 * It simply uses what was grabbed from the database through the DAO
	 * @return
	 */
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	public boolean addEmployee(Employee employee) {
		return repository.insert(employee);
	}

	public boolean login(String u, String p) {
		if (u == "correctUsername") {    // late we'll use SQL statements to replace these values
			if (p == "correctPassword") { 
				return true;
			}
		}
		return false;
	}
	
}
