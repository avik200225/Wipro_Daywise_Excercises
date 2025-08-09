package com.wipro.servdemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/httpserv")
public class HttpsServletDemo extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("--do Get---");		
	}
}
