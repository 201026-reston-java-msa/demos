package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() {
        super();
    }

    /*
     * JSON is JavaScript Object Notation, which is a lightweight, text-based, language agnostic data exchange format that is easy for humans to read and for machines to read.
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null ) {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":\""+ session.getAttribute("username")+"\"}");
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":null}");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
