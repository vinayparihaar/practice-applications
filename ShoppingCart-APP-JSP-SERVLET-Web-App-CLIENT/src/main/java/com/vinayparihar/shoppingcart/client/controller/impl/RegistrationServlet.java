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

import com.vinayparihar.shoppingcart.client.bean.Address;
import com.vinayparihar.shoppingcart.client.bean.User;
import com.vinayparihar.shoppingcart.client.service.impl.UserRegistrationService;
import com.vinayparihar.shoppingcart.client.utils.Utils;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationServlet.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// super.doGet(req, resp);
		LOGGER.debug("Entered doGet.");
		response.sendRedirect("./register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		User user = null;
		Address address = null;
		PrintWriter printWriter = null;
		boolean result = false;
		boolean isValid = true;
		try {

			LOGGER.debug("Entered doPost.");
			response.setContentType("text/html");
			printWriter = response.getWriter();

			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");

			String addLineOne = request.getParameter("addlineone");
			String addLineTwo = request.getParameter("addlinetwo");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipcode = request.getParameter("zipcode");
			String country = request.getParameter("country");

			if (Utils.isEmpty(firstName)) {
				LOGGER.error("First Name is empty. ");
				request.setAttribute("firstname", "*First Name is required. ");
				isValid = false;
			} else {
				request.setAttribute("ufirstname", firstName);
				/* request.getSession().setAttribute("firstname", firstName); */

			}
			if (Utils.isEmpty(lastName)) {
				LOGGER.error("Last Name is empty. ");
				request.setAttribute("lastname", "*Last Name is required. ");
				isValid = false;
			} else {
				request.setAttribute("ulastname", lastName);
				/* request.getSession().setAttribute("lastname", lastName); */
			}
			if (Utils.isEmpty(email)) {
				LOGGER.error("Email is empty. ");
				request.setAttribute("email", "*Email is required. ");
				isValid = false;
			} else {
				request.setAttribute("uemail", email);
				/* request.getSession().setAttribute("email", email); */
			}
			if (Utils.isEmpty(phone)) {
				LOGGER.error("Phone Number is empty. ");
				request.setAttribute("phone", "*Phone Number is required. ");
				isValid = false;
			} else {
				request.setAttribute("uphone", phone);
				/* request.getSession().setAttribute("phone", phone); */
			}
			if (Utils.isEmpty(password)) {
				LOGGER.error("Password is empty. ");
				request.setAttribute("password", "*Password is required. ");
				isValid = false;
			}
			if (Utils.isEmpty(addLineOne)) {
				LOGGER.error("Line 1 of address is empty. ");
				request.setAttribute("addlineone", "*Address Line1 is required. ");
				isValid = false;
			} else {
				request.setAttribute("uaddlineone", addLineOne);
				/* request.getSession().setAttribute("addlineone", addLineOne); */
			}
			if (Utils.isEmpty(addLineTwo)) {
				LOGGER.error("Line 2 of address is empty. ");
				request.setAttribute("addlinetwo", "*Address Line2 is required. ");
				isValid = false;
			} else {
				request.setAttribute("uaddlinetwo", addLineTwo);
				/* request.getSession().setAttribute("addlinetwo", addLineTwo); */
			}
			if (Utils.isEmpty(city)) {
				LOGGER.error("City is empty. ");
				request.setAttribute("city", "*City is required. ");
				isValid = false;
			} else {
				request.setAttribute("ucity", city);
				/* request.getSession().setAttribute("city", city); */
			}
			if (Utils.isEmpty(state)) {
				LOGGER.error("State is empty. ");
				request.setAttribute("state", "*State is required. ");
				isValid = false;
			} else {
				request.setAttribute("ustate", state);
				/* request.getSession().setAttribute("state", state); */
			}
			if (Utils.isEmpty(zipcode)) {
				LOGGER.error("ZipCode is empty. ");
				request.setAttribute("zipcode", "*Zipcode is required. ");
				isValid = false;
			} else {
				request.setAttribute("uzipcode", zipcode);
				/* request.getSession().setAttribute("zipcode", zipcode); */
			}
			if (Utils.isEmpty(country)) {
				LOGGER.error("Country is empty. ");
				request.setAttribute("country", "*Country is required. ");
				isValid = false;
			} else {
				request.setAttribute("ucountry", country);
				/* request.getSession().setAttribute("country", country); */
			}

			if (!isValid) {
				LOGGER.error("Registration failed,redirecting to registration page. ");
				printWriter.println("<html>");
				printWriter.println("<body>");
				printWriter.println("<center>");
				printWriter.println("<h1>Registration Failed</h1>");
				printWriter.println("</center>");
				printWriter.println("</body>");
				printWriter.println("</html>");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			} else {
				user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPhone(phone);
				user.setPassword(password);

				address = new Address();
				address.setLineOne(addLineOne);
				address.setLineTwo(addLineTwo);
				address.setCity(city);
				address.setState(state);
				address.setZipcode(zipcode);
				address.setCountry(country);

				user.setAddress(address);
				UserRegistrationService userRegistrationService = new UserRegistrationService();
				result = userRegistrationService.registerUser(user);
				if (result == true) {
					printWriter.println("<html>");
					printWriter.println("<body>");
					printWriter.println("<center>");
					printWriter.println("<h1>Thanks for Registering with us :</h1>");
					printWriter.println("To login with new UserId(Email) and Password<a href=login.jsp>Click here</a>");
					LOGGER.debug("Registration Successfull!!");

				}
				printWriter.println("</center>");
				printWriter.println("</body>");
				printWriter.println("</html>");
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
