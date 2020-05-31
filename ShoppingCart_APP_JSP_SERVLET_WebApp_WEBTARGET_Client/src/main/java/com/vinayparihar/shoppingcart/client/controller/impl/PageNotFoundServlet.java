package com.vinayparihar.shoppingcart.client.controller.impl;
/**
 * @author VinayParihar
 * @date Apr 29, 2020 @time 2:27:13 PM 
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class PageNotFoundServlet
 */
public class PageNotFoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = LoggerFactory.getLogger(PageNotFoundServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.debug("Entered doGet. ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("./login.jsp").forward(request, response);
	}

}
