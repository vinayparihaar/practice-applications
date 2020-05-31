package com.vinayparihar.shoppingcart.client.controller.impl;

/**
 * @author VinayParihar
 * @date Apr 29, 2020 @time 2:27:13 PM 
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinayparihar.shoppingcart.client.bean.Login;
import com.vinayparihar.shoppingcart.client.bean.User;
import com.vinayparihar.shoppingcart.client.service.impl.UserLoginService;
import com.vinayparihar.shoppingcart.client.utils.Utils;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// super.doGet(request, response);
		LOGGER.debug("Entered doGet. ");
		response.sendRedirect("./login.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		User user = null;
		Login login = null;
		boolean isValid = true;
		PrintWriter printWriter = null;
		UserLoginService userLoginService = null;
		try {
			LOGGER.debug("Entered doPost. ");
			response.setContentType("text/html");
			printWriter = response.getWriter();

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (Utils.isEmpty(email)) {
				LOGGER.error("Email is empty. ");
				request.setAttribute("email", "*Email is required. ");
				isValid = false;
			}
			if (Utils.isEmpty(password)) {
				LOGGER.error("Password is empty. ");
				request.setAttribute("password", "*Password is required. ");
				isValid = false;
			}
			if (!isValid) {
				LOGGER.error("Login failed,redirecting to Login page. ");
				response.sendRedirect("error.jsp");
			} else {
				login = new Login();
				login.setEmail(email);
				login.setPassword(password);
				userLoginService = new UserLoginService();
				user = userLoginService.loginUser(login);

				if (user == null) {
					LOGGER.error("Login failed,redirecting to error page. ");
					response.sendRedirect("/error.jsp");

				} else {
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("/loginhome.jsp").forward(request, response);
					LOGGER.debug("Login Successfull!!");

				}
			}

		} catch (IOException ioException) {
			LOGGER.error("IOException occured in doPost. " + ioException);
		} catch (Exception exception) {
			LOGGER.error("Exception occured in doPost. " + exception);
		} finally {
			LOGGER.debug("PrintWriter closed in doPost. ");
			printWriter.close();
		}
	}
}
