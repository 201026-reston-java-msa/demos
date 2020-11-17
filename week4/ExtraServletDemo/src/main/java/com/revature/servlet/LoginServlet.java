package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {

	/**
	 * /*
 * GET and POST are both HTTP verbs/methods. These two verbs are different
 * ways that we can send requests to a server.
 * 
 * GET requests will request information to be sent back in response
 * POST requests will send information that needs to be saved in response
 * 
 * You can still put information in the body of a GET request, however,
 * it is limited to 2048 characters.
 * POST requests have a near limitless capacity in the body.
 * 
 * In both cases the parameters passed are stored in a header called
 * QUERY_STRING
 */
	
	/*
	 * It is customary to create a doGet and doPost method for a Servlet
	 * We do not generally override the service/init/destroy methods
	 */

	private static final long serialVersionUID = 817105812389880890L;

	// return login page for GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	/*
	 * HttpSession API
The Servlet API provides HttpSession Interface, which provides a way to identify a user and to store information about that user. 

For the client's first request, the Servlet Container generates a unique session ID and gives it back to the client with a response. 

Thereafter, the client sends the session ID with each request to the server.

The getSession() method of the HttpServletRequest object returns a user's session. Any servlet can access the HttpSession object using getSession() method.

setAttribute(key,object) - used to bind an object to the session, using the key specified.

getAttribute(String) - used to retrieve a specific saved object from the session object, using its key.
	 */
	
	// perform authentication for POST request
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		//grab params from request
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (AuthenticationService.isValidUser(username, password)) {
			//pw.println("welcome, "+username);
			//pw.println("<a href=\"helloWorld.html\">Go Back</a>");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
	}
}
