package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {
	
	public static boolean insert(Employee e) {
		return new EmployeeDAOImpl().insert(e);
	}
	
	public static boolean update(Employee e) {
		return new EmployeeDAOImpl().update(e);
	}
	
	public static List<Employee> findAll() {
		return new EmployeeDAOImpl().findAll();
	}
	
	public static Employee findByUsername(String username) {
		List<Employee> all = new EmployeeDAOImpl().findAll();
		
		for (Employee e : all) {
			if (e.getUsername().equals(username)) {
				return e;
			}
		}
		
		return null;
	}
	
	// This method invokes the above method
	public static Employee confirmLogin(String username, String password) {
		Employee e = findByUsername(username);
		if (e == null) {
			return null;
		}
		
		if (e.getPassword().equals(password)) {
			return e;
		} else {
			return null;
		}
	}
	
	public static EmployeeDTO convertToDTO(Employee e) {
		return new EmployeeDTO(e.getId(),
				
				e.getFirstName(),
				e.getLastName(),
				e.getUsername(),
				e.getPassword(),
				e.getHireDate().toString());
	}
	
	
	
	
	
	
	
	
	
}
