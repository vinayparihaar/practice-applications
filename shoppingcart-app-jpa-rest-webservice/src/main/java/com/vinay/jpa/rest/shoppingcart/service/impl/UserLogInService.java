package com.vinay.jpa.rest.shoppingcart.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.jpa.rest.shoppingcart.bean.Address;
import com.vinay.jpa.rest.shoppingcart.bean.LogIn;
import com.vinay.jpa.rest.shoppingcart.bean.User;
import com.vinay.jpa.rest.shoppingcart.dao.IUserLogInDAO;
import com.vinay.jpa.rest.shoppingcart.dao.impl.UserLogInDAO;
import com.vinay.jpa.rest.shoppingcart.model.UserDetails;
import com.vinay.jpa.rest.shoppingcart.service.IUserLogInService;

public class UserLogInService implements IUserLogInService {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserLogInService.class);
	private IUserLogInDAO iUserLogInDAO;
	private User user;
	private Address address;

	@Override
	public User getUserbyEmail(String email) {
		LOGGER.debug("Entered getUserbyEmail. ");
		iUserLogInDAO = new UserLogInDAO();
		UserDetails userDetails = iUserLogInDAO.getUserbyEmail(email);
		user = new User();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setPhone(userDetails.getPhone());
		user.setPassword(userDetails.getPassword());

		address = new Address();

		address.setLineOne(userDetails.getAddressDetails().getAddressLineOne());
		address.setLineTwo(userDetails.getAddressDetails().getAddressLineTwo());
		address.setCity(userDetails.getAddressDetails().getAddressCity());
		address.setState(userDetails.getAddressDetails().getAddressState());
		address.setZipcode(userDetails.getAddressDetails().getAddressZipcode());
		address.setCountry(userDetails.getAddressDetails().getAddressCountry());

		user.setAddress(address);

		return user;
	}

	@Override
	public User authenticateUser(LogIn logIn) {
		LOGGER.debug("Entered getUserbyEmail. ");
		iUserLogInDAO = new UserLogInDAO();
		user = new User();
		address = new Address();

		UserDetails userDetails = iUserLogInDAO.getUserbyEmail(logIn.getEmail());

		if (userDetails != null) {

			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setEmail(userDetails.getEmail());
			user.setPhone(userDetails.getPhone());
			user.setPassword(userDetails.getPassword());
			if (userDetails.getAddressDetails() != null) {
				address.setLineOne(userDetails.getAddressDetails().getAddressLineOne());
				address.setLineTwo(userDetails.getAddressDetails().getAddressLineTwo());
				address.setCity(userDetails.getAddressDetails().getAddressCity());
				address.setState(userDetails.getAddressDetails().getAddressState());
				address.setZipcode(userDetails.getAddressDetails().getAddressZipcode());
				address.setCountry(userDetails.getAddressDetails().getAddressCountry());
			}
			user.setAddress(address);
			return user;

		}

		else {
			return null;
		}

	}

}
