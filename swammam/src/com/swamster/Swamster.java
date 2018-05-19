package com.swamster;

import java.io.File;
import java.io.FileInputStream;


import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * @author Aria
 */

/**
 * Servlet implementation class Swamster
 */
@WebServlet("/Swamster")
@MultipartConfig()

public class Swamster extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    
    public Swamster() {
        super();
    }
    
    /**
	 * Collects import .csv file request. It passes imported .csv through backend parsing java classes and creates a .json file
	 * and sends it back to the user for download.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        Part uploadedFile = request.getPart("input"); // recieves .csv input
        InputStream content = uploadedFile.getInputStream();
       csvParse getJson = new csvParse(); // sends csv through backend 
       getJson.csvParser(content);

       response.getOutputStream().println(getJson.getJson()); // Creates json
       
       
       
       File file = new File("C:\\Users\\Aria\\eclipse-workspace\\swammam\\WebContent\\WEB-INF\\export.json");
       
     //Create the file
     try{
    	 file.createNewFile();
     }catch(Exception e){
    	 
     }
    
     // Declares file type 
     response.setContentType("application/json");

     // Shows the download dialog
     response.setHeader("Content-disposition","attachment; filename=export.json");

     // Sends file for download
     
     OutputStream out = response.getOutputStream();
     FileInputStream in = new FileInputStream(file);
     byte[] buffer = new byte[4096];
     int length;
     while ((length = in.read(buffer)) > 0){
        out.write(buffer, 0, length);
     }
     in.close();
     out.flush();

       
       }
	
	}










