package com.bootcamp.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingServlet extends HttpServlet {

	private static final long serialVersionUID = 11985107571187021L;

	private static final Logger LOGGER = LogManager.getLogger(LoggingServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String paymentMethod = req.getParameter("paymentMethod");
		final String status = req.getParameter("status");
		
//		LOGGER.info("doGet() metod invoked");
	     LOGGER.info("action=process_payment, payment_method={}, status={}", paymentMethod, status);
		
	}
	
	
	
}
