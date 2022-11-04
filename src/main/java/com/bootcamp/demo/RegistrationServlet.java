package com.bootcamp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	// if you want to load it in VM need mo serial id, pagnagppersist ng object, dapat meron. 
	// para maserialize mo to a file or data yung nasa reference id which is yung object na ininstanciate. 
	private static final long serialVersionUID = -9174495987589377144L; // the reference that you want sa object, gusto mo ipersist yon. Pag hindi serializable, hindi mawwritten object into a string. 
	private static final Logger LOGGER = LogManager.getLogger(RegistrationServlet.class);
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		final RegistrationFormBean registrationFormBean = toRegistrationFormBean(request);
		request.setAttribute("registrationFormBean", registrationFormBean);
		LOGGER.info("action=register, registration_form_bean={}", registrationFormBean);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/success");
		dispatcher.forward(request, response);
	}

	// we are converting userInput from form in index.html to object here. 
	private RegistrationFormBean toRegistrationFormBean (HttpServletRequest request) {
		RegistrationFormBean registrationFormBean = new RegistrationFormBean();
		registrationFormBean.setFirstName(request.getParameter("firstName"));
		registrationFormBean.setLastName(request.getParameter("lastName"));
		registrationFormBean.setEmail(request.getParameter("emai"));
		registrationFormBean.setPassword(request.getParameter("password"));
		registrationFormBean.setConfirmPassword(request.getParameter("confirmPassword"));
		return registrationFormBean;
	}
	
}
