package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// URL Rewriting
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI().replace("/EmployeeServletDemo/", "");
		
		
		switch(URI) {
		case "login":
			RequestHelper.processLogin(request, response);
			break;
//		case "logout":
//			RequestHelper.processLogout(request, response);
//			break;
//		case "employees":
//			RequestHelper.processEmployees(request, response);
//			break;
			
			// ^ I will make these methods later...
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
