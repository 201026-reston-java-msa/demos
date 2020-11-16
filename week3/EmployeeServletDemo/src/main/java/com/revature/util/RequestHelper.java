package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.models.LoginTemplate;
import com.revature.services.EmployeeService;

public class RequestHelper {
	
	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		
		// we are just transferring our Reader data to our StringBuilder, line by line
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		System.out.println(body);
		
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		
		log.info("User attempted to login with username " + username);
		Employee e = EmployeeService.confirmLogin(username, password);
		
		if(e != null) {
			// Let's get the current session or create one if none exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			// create an EmployeeDTO from Employee object
			// create a method to create an employee DTO (in EmployeeService class)
			EmployeeDTO eDTO = EmployeeService.convertToDTO(e);
			
			pw.println(om.writeValueAsString(eDTO));
			
			log.info(username + " has successfully logged in.");
		} else {
			res.setContentType("application/json");
			res.setStatus(204); // this means that the connection was successful but no user found!
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
