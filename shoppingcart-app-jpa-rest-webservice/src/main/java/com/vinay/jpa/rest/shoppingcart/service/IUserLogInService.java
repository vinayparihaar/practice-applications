package com.vinay.jpa.rest.shoppingcart.service;

import com.vinay.jpa.rest.shoppingcart.bean.LogIn;
import com.vinay.jpa.rest.shoppingcart.bean.User;

public interface IUserLogInService {

	public User getUserbyEmail(String email);
	public User authenticateUser(LogIn logIn);

}
