package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request.getSession(false) means: give me the session if it exists, otherwise do not create a new instance (and thus return null)
		HttpSession session = request.getSession(false);
		
		// check whether the session exists
		if (session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("profile.html").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
 	}
	
	
	
	
	
	
	
	

}
