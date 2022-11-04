package com.bootcamp.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/success")
public class RegistrationSuccessServlet extends HttpServlet {
   
	
	private static final long serialVersionUID = 8376079564351995011L;
	private static final Logger LOGGER = LogManager.getLogger(RegistrationServlet.class);


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RegistrationFormBean registrationFormBean = (RegistrationFormBean) request.getAttribute("registrationFormBean");
		LOGGER.info("action=register, status=success, registration_form_bean={}", registrationFormBean);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("Welcome " + registrationFormBean.getFirstName() + " " + registrationFormBean.getLastName());
	
		out.flush();
		out.close();
	}
	
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
