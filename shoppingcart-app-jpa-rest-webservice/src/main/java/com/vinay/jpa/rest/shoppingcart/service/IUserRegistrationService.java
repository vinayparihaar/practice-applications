package com.vinay.jpa.rest.shoppingcart.service;

import com.vinay.jpa.rest.shoppingcart.bean.User;

public interface IUserRegistrationService {
	public boolean createUser(User user);
	public boolean ifUserExist(String email);

}
