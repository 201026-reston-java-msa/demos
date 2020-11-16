package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.util.HtmlTemplate;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LogoutServlet.class);

	public LogoutServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out");
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			HtmlTemplate.goBack(pw);
			
			session.invalidate();
			
		}

		response.setStatus(200);
	}

}
