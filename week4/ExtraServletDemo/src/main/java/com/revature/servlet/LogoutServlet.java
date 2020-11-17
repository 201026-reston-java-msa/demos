package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("base.html").include(request, response);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		pw.print("you are successfully logged out");
		pw.println("</div>");
		pw.println("<a href=\"login\">back to login</a>");
		pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/*
	 * doGet() and doPost() are called in different
ocassions, when you call an URL you normally make a
GET request, when you put a form and set the <FORM
METHOD=POST> then you have a post request. Forms can
be either get or post, so to process a form request
yuou may program both methods or you mey loose some
requests
so, the easieste way is to call doPost() from doGet()
or viceversa or point both of them to your function.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
