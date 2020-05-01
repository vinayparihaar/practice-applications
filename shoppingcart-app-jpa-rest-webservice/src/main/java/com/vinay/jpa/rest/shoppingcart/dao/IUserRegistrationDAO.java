package com.vinay.jpa.rest.shoppingcart.dao;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import com.vinay.jpa.rest.shoppingcart.model.UserDetails;

public interface IUserRegistrationDAO {
	
	public boolean createUser(UserDetails userDetails);
	public boolean ifUserExist(String email);

}
