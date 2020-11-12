package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

// To make a custom  servlet you must extend HttpServlet
public class HelloServlet extends HttpServlet{
	
	private Logger log = Logger.getLogger(HelloServlet.class);
	/*
	 * How to create a Servlet (only 3 steps!)
	 * 
	 * Step 1:
	 * 	- create a class that inherits either HttpServlet or Generic Servlet
	 * or Servlet
	 * 	- typically HttpServlet is used
	 * 
	 * Step 2:
	 * 	- override methods
	 * 	- we override doGet and doPost (NOT the service method and NOT the init method)
	 * 
	 * Step 3: Configure servlet in web.xml (deployment descriptor)
	 */

	// NEVER override this method
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//	} This method is abstracted away from us!
	
	// The ServletConfig params are specific to a PARTICULAR servlet.
	// ServletConfig is used for initializing 1 particular servlet
	
	// The ServletContext object is GLOBAL to the entire web app
		//(ServletContext is an object that all servlets can access)
	
	@Override
	public void init() throws ServletException{
		log.trace("init(): Initiatizes the servlet for the first time ofuse");
		log.trace("init: called once for each servlet during the lifetime of an application.");
		super.init();
	}
	
	// PROTECTED is the access modifier we apply to custome do-methods methods
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.trace("Handling a GET request");
		// The PrintWriter object allows us to write raw html or text to the client
		// the PrintWriter uses the response object to write to the client
		PrintWriter pw = res.getWriter();
//		pw.write("Hey world!");
		pw.write("<html><head><title>Hello World!</title></head><body>;");
		pw.write("<h1>Hello World...</h1>"
		+ "<a href='index.html'> request a color</a></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.trace("Handling a POST request");
		String color = null;
		color = req.getParameter("color");
		log.trace("Color recieved is " + color);
		res.getWriter().write("<html><head><title>Colors!</title></head>"
				+ "<body style=\"background-color:" + color + "\">"
				+ "<a href=\"index.html\">Go Back</a>"
				+"<br><a href=\"hello\">hello</a></body></html>");
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// do not override this method!!! - this is for demo purposes only
		log.trace("Service: this is the workhorse.  The service() method will call your do-method methods.");
		log.trace("Service: This method is called every single time you access a servlet");
		super.service(req, res);
	}
	
	
	@Override
	public void destroy() {
		log.trace("destroy: close the servlet resource etc. Preps for the end of the application");
		log.trace("destroy: when the server shuts down");
		super.destroy();
	}
	
	
	
	
	
	
	
}
