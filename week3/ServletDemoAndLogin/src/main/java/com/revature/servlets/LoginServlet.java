package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.services.AuthenticationService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    /*
     * GET & POST are both HTTP verbs/methods.  These two verbs are diffierent ways that we can send
     * requests to a server.
     * 
     * GET requests will request information to be sent back in response
     * POST request will send information that needs to be saved in response
     * 
     * You can still put info in the body of a GET request , however, it's limited to 2048 characters.
     * 
     * POST requests have a near limitless capacity in the body.
     * In both cases the parameters are stored in a header called the QUERY_STRING
     */
    
    // return login page for GET request
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	/*
	 * The HttpSession API is provides a way to identify a user and to store information about that user.  For the client's first request, the Servlet container generates a unique session ID and gives it back to the client with a RESPONSE.
	 * 
	 * The getSession() method of the HttpServletRequest object returns a user's session.  Any servlet can access the HttpSession object.
	 * 
	 * setAttribute(key, object) is used to bind an object to the session by the key specified
	 * getAttribute(String) is used to retrieve a specific saved object from the session object using its KEY.
	 */
	
	//perform authentication for POST request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		pw.println("welcome, " + username);
//		pw.println("<a href='index.html'>Go home</a>");
		if (AuthenticationService.isValidUser(username, password)) {
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			response.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "incorrect credentials");
			response.sendRedirect("login");
		}
	}

	
	
	
	
	
	
	
	
}
