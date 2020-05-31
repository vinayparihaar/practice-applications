package com.vinay.jpa.rest.shoppingcart.service.impl;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import java.util.ArrayList;
import java.util.List;

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
	private List<User> userList;

	@Override
	public User getUserbyEmail(String email) {
		LOGGER.debug("Entered getUserbyEmail. ");
		iUserLogInDAO = new UserLogInDAO();
		UserDetails userDetails = iUserLogInDAO.getUserbyEmail(email);

		if (userDetails != null) {

			user = new User();

			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setEmail(userDetails.getEmail());
			user.setPhone(userDetails.getPhone());
			user.setPassword(userDetails.getPassword());

			if (userDetails.getAddressDetails() != null) {

				address = new Address();

				address.setLineOne(userDetails.getAddressDetails().getAddressLineOne());
				address.setLineTwo(userDetails.getAddressDetails().getAddressLineTwo());
				address.setCity(userDetails.getAddressDetails().getAddressCity());
				address.setState(userDetails.getAddressDetails().getAddressState());
				address.setZipcode(userDetails.getAddressDetails().getAddressZipcode());
				address.setCountry(userDetails.getAddressDetails().getAddressCountry());
			}
			user.setAddress(address);
			return user;

		} else {
			LOGGER.error("UserDetails are null in getUserbyEmail. ");
			return null;
		}
	}

	@Override
	public User authenticateUser(LogIn logIn) {

		LOGGER.debug("Entered authenticateUser. ");
		iUserLogInDAO = new UserLogInDAO();
		UserDetails userDetails = iUserLogInDAO.getUserbyEmail(logIn.getEmail());

		if (userDetails != null) {
			user = new User();

			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setEmail(userDetails.getEmail());
			user.setPhone(userDetails.getPhone());
			user.setPassword(userDetails.getPassword());

			if (userDetails.getAddressDetails() != null) {
				address = new Address();

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
			LOGGER.error("UserDetails are null in authenticateUser. ");
			return null;
		}

	}

	@Override
	public List<User> getAllUsers(int offset, int limit) {

		LOGGER.debug("Entered getAllUsers. ");
		iUserLogInDAO = new UserLogInDAO();
		List<UserDetails> list = iUserLogInDAO.getAllUsers(offset, limit);
		if (list != null && !list.isEmpty()) {
			userList = new ArrayList<User>();
			for (UserDetails userDetails : list) {

				if (userDetails != null) {
					user = new User();

					user.setFirstName(userDetails.getFirstName());
					user.setLastName(userDetails.getLastName());
					user.setEmail(userDetails.getEmail());
					user.setPhone(userDetails.getPhone());
					user.setPassword(userDetails.getPassword());

					if (userDetails.getAddressDetails() != null) {

						address = new Address();
						address.setLineOne(userDetails.getAddressDetails().getAddressLineOne());
						address.setLineTwo(userDetails.getAddressDetails().getAddressLineTwo());
						address.setCity(userDetails.getAddressDetails().getAddressCity());
						address.setState(userDetails.getAddressDetails().getAddressState());
						address.setZipcode(userDetails.getAddressDetails().getAddressZipcode());
						address.setCountry(userDetails.getAddressDetails().getAddressCountry());
					}
					user.setAddress(address);
					userList.add(user);
				} else {
					LOGGER.error("UserDetails are null in getAllUsers. ");
					return null;
				}
			}
		}
		return userList;
	}
}
