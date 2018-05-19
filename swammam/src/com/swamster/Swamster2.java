
package com.swamster;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Aria
 */



/**
 * Servlet implementation class Swamster2
 */
@WebServlet("/Swamster2")
@MultipartConfig()
public class Swamster2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Swamster2() {
        super();
        
    }


	/**
	 * Collects single node creation requests from the web page. It returns an html print of the web page with a send button
	 * that send inputted information to the database.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String enter = request.getParameter("enter"); // recieves call from submit button
		String typein = request.getParameter("text"); // recieves call from inputted text
		
		response.getOutputStream().println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"design.css\"/>\r\n" + 
				"<title>Swamster | Home</title>\r\n" + 
				"</head>\r\n" + 
				"<body class=\"bodybackground\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"topnav\" id=\"indextopnav\">\r\n" + 
				"  <a href=\"index.html\" class=\"active\">Home</a>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"defaultbody\" id=\"indexbody3\">"+"\n"+
				"<p> Press send to send your text to the database.</p>"); // prints html as a response
		
		
		
		response.getOutputStream().println("<button type=\"button\"  onclick=\"send("+"'"+ typein+"'"+" )\">Send\r\n" +" </button> "); // send button (calls javascript function on webpage)
		
		
		RequestDispatcher go = request.getRequestDispatcher("/test.html");
		go.include(request, response);
	}

}
