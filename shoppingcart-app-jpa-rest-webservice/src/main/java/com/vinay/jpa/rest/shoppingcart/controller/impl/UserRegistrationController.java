package com.vinay.jpa.rest.shoppingcart.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.jpa.rest.shoppingcart.bean.User;
import com.vinay.jpa.rest.shoppingcart.exceptions.InvalidInputException;
import com.vinay.jpa.rest.shoppingcart.service.IUserRegistrationService;
import com.vinay.jpa.rest.shoppingcart.service.impl.UserRegistrationService;
import com.vinay.jpa.rest.shoppingcart.utils.Utils;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/register")
public class UserRegistrationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

	private IUserRegistrationService iUserRegistrationService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean createUser(User user) {
		LOGGER.debug("Entered createUser.  ");
		validateUser(user);
		iUserRegistrationService = new UserRegistrationService();
		return iUserRegistrationService.createUser(user);

	}

	public boolean ifUserExist(String email) {
		LOGGER.debug("Entered ifUserExist.  ");
		if (Utils.isEmpty(email)) {
			LOGGER.error("Email is invalid or empty. ");
			throw new InvalidInputException("Email is invalid or empty. ");
		}
		iUserRegistrationService = new UserRegistrationService();
		return iUserRegistrationService.ifUserExist(email);
	}

	private void validateUser(User user) {
		LOGGER.error("Entered validateUser. ");
		if (user == null) {
			throw new InvalidInputException("*Form Cannot be empty.Please fill all the required fields. ");
		}
		if (user.getFirstName() == null || user.getFirstName().trim().length() <= 0) {
			throw new InvalidInputException("*First Name is required. ");
		}
		if (user.getLastName() == null || user.getLastName().trim().length() <= 0) {
			throw new InvalidInputException("*Last Name is required. ");
		}
		if (user.getEmail() == null || user.getEmail().trim().length() <= 0) {
			throw new InvalidInputException("*Email is required. ");
		}
		if (user.getPhone() == null || user.getPhone().trim().length() <= 0) {
			throw new InvalidInputException("*Phone Number is required. ");
		}
		if (user.getPassword() == null || user.getPassword().trim().length() <= 0) {
			throw new InvalidInputException("*Password is required. ");
		}
		if (user.getAddress().getLineOne() == null || user.getAddress().getLineOne().trim().length() <= 0) {
			throw new InvalidInputException("*Line 1 of address is required. ");
		}
		if (user.getAddress().getLineTwo() == null || user.getAddress().getLineTwo().trim().length() <= 0) {
			throw new InvalidInputException("*Line 2 of address is required. ");
		}
		if (user.getAddress().getCity() == null || user.getAddress().getCity().trim().length() <= 0) {
			throw new InvalidInputException("*City is required. ");
		}
		if (user.getAddress().getState() == null || user.getAddress().getState().trim().length() <= 0) {
			throw new InvalidInputException("*State is required. ");
		}

		if (user.getAddress().getZipcode() == null || user.getAddress().getZipcode().trim().length() <= 0) {
			throw new InvalidInputException("*Zipcode is required. ");
		}

		if (user.getAddress().getCountry() == null || user.getAddress().getCountry().trim().length() <= 0) {
			throw new InvalidInputException("*Country is required. ");
		}
	}

}
