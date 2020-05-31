package com.vinay.jpa.rest.shoppingcart.service;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import com.vinay.jpa.rest.shoppingcart.bean.User;

public interface IUserRegistrationService {
	public boolean createUser(User user);
	public boolean ifUserExist(String email);

}
