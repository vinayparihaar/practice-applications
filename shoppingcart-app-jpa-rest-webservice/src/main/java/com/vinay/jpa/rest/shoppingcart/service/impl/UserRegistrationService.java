package com.vinay.jpa.rest.shoppingcart.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.jpa.rest.shoppingcart.bean.User;
import com.vinay.jpa.rest.shoppingcart.dao.IUserRegistrationDAO;
import com.vinay.jpa.rest.shoppingcart.dao.impl.UserRegistrationDAO;
import com.vinay.jpa.rest.shoppingcart.model.AddressDetails;
import com.vinay.jpa.rest.shoppingcart.model.UserDetails;
import com.vinay.jpa.rest.shoppingcart.service.IUserRegistrationService;

public class UserRegistrationService implements IUserRegistrationService {
	private static final Logger LOGGER= LoggerFactory.getLogger(UserRegistrationService.class);
	private IUserRegistrationDAO iUserRegistrationDAO;
	private UserDetails userDetails;
	private AddressDetails addressDetails;

	@Override
	public boolean createUser(User user) {
		LOGGER.debug("Entered createUser. ");
		userDetails = new UserDetails();
		userDetails.setFirstName(user.getFirstName());
		userDetails.setLastName(user.getLastName());
		userDetails.setEmail(user.getEmail());
		userDetails.setPhone(user.getPhone());
		userDetails.setPassword(user.getPassword());

		
		  addressDetails = new AddressDetails();
		  addressDetails.setAddressId(user.getAddress().getAddressid());
		  addressDetails.setAddressLineOne(user.getAddress().getLineOne());
		  addressDetails.setAddressLineTwo(user.getAddress().getLineTwo());
		  addressDetails.setAddressCity(user.getAddress().getCity());
		  addressDetails.setAddressState(user.getAddress().getState());
		  addressDetails.setAddressZipcode(user.getAddress().getZipcode());
		  addressDetails.setAddressCountry(user.getAddress().getCountry());
		 

		userDetails.setAddressDetails(addressDetails);
		
		iUserRegistrationDAO=new UserRegistrationDAO();

		return iUserRegistrationDAO.createUser(userDetails);
	}

	@Override
	public boolean ifUserExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
