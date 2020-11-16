package com.revature.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/*
 * This is just going to be a convenience, a HELPER CLASS to faciliate
 * createing html documents from Java more easily
 */
public class HtmlTemplate {

	public static void goBack(PrintWriter pw) {
		pw.println("<hr><input type='button' value='BACK'"
				+ "onclick='goBack()'>"
				+ "<script>"
				+ "function goBack() { window.history.back(); }"
				+ "</script>");	
	}
	
	
	public static PrintWriter getHtmlWriter(HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		return res.getWriter();
	}
	
	// .. the ...header parameter is VAR ARGS which accepts an array of params (of an unspecified capacity)
	// -> PrintWriter + ["header1" , "header2",  header3"...]
	public static void printTableHeaders(PrintWriter pw, String ...headers) {
		pw.println("<table border=2px><tr>");
		for (String h : headers) {
			pw.println("<th>" + h + "</th>");
		}
		pw.println("</tr></table>");
	}
	
}
