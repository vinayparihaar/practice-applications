package com.vinay.jpa.rest.shoppingcart.dao;

import com.vinay.jpa.rest.shoppingcart.model.UserDetails;

public interface IUserRegistrationDAO {
	
	public boolean createUser(UserDetails userDetails);
	public boolean ifUserExist(String email);

}
