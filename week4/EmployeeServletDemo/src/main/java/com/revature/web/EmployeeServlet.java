package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.services.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// an Object Mapper allows us to convert a Java object to JSON and vice versa
	private static ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		List<Employee> all = EmployeeService.findAll();
		List<EmployeeDTO> allDTO = new ArrayList<>();
		
		for(Employee e : all) {
			allDTO.add(new EmployeeDTO(e.getId(),
					e.getFirstName(),
					e.getLastName(),
					e.getUsername(),
					e.getPassword(),
					e.getHireDate().toString()));
		}
		
		String json = om.writeValueAsString(allDTO);
		
		PrintWriter pw = response.getWriter();
		pw.println(json);
	}



}
