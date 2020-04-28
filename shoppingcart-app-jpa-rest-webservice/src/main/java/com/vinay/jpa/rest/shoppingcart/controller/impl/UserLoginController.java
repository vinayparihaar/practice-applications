package com.vinay.jpa.rest.shoppingcart.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.jpa.rest.shoppingcart.bean.LogIn;
import com.vinay.jpa.rest.shoppingcart.bean.User;
import com.vinay.jpa.rest.shoppingcart.exceptions.InvalidInputException;
import com.vinay.jpa.rest.shoppingcart.service.IUserLogInService;
import com.vinay.jpa.rest.shoppingcart.service.impl.UserLogInService;
import com.vinay.jpa.rest.shoppingcart.utils.Utils;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
public class UserLoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

	IUserLogInService iUserLogInService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{email}")
	public User getUserbyEmail(@PathParam("email") String email) {
		LOGGER.debug("Entered getUserbyEmail. ");
		if(Utils.isEmpty(email))
		{
			LOGGER.error("Email empty or null in getUserbyEmail. ");
			throw new InvalidInputException("*Invalid email. ");
		}
		iUserLogInService = new UserLogInService();
		return iUserLogInService.getUserbyEmail(email);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/login")
	public User authenticateUser(LogIn logIn) {
		LOGGER.debug("Entered authenticateUser.  ");
		/*
		 * if (logIn == null || logIn.getEmail() == null ||
		 * logIn.getEmail().trim().length() <= 0 || logIn.getPassword().trim().length()
		 * <= 0 || logIn.getPassword() == null)
		 */
		if (logIn == null || Utils.isEmpty(logIn.getEmail()) || Utils.isEmpty(logIn.getPassword())) {
			LOGGER.error("Email or Password is Invalid. ");
			throw new InvalidInputException("*Invalid Email or Password. ");
		}
		iUserLogInService = new UserLogInService();
		return iUserLogInService.authenticateUser(logIn);

	}

}
