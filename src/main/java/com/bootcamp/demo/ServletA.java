package com.bootcamp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
* SCOPES
* application context   -> ServletContext      (undeploy) - Global - ex. List of items, List of countries
* request   -> HttpServletRequest  use dispatcher whenever you use request
* session   -> HttpSession
* page(JSP) -> PageContext
*
* setAttribute(String, Object)
* getAttribute(String, Object)
* removeAttribute(String, Object)
*/
public class ServletA extends HttpServlet {

	private static final long serialVersionUID = 2265793564953959394L;

	private static final Logger LOGGER = LogManager.getLogger(ServletA.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("action=do_get, source=servlet_a");

		final ServletContext context = getServletContext();
		context.setAttribute("name", "John Doe");

		request.setAttribute("email", "john.doe@gmail.com");
		// response.sendRedirect("./b");

		RequestDispatcher dispatcher = request.getRequestDispatcher("b");
		dispatcher.forward(request, response);
	}

}