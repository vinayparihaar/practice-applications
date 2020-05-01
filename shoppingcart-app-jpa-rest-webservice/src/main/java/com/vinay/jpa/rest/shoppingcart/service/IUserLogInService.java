package com.vinay.jpa.rest.shoppingcart.service;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import java.util.List;

import com.vinay.jpa.rest.shoppingcart.bean.LogIn;
import com.vinay.jpa.rest.shoppingcart.bean.User;

public interface IUserLogInService {

	public User getUserbyEmail(String email);
	public List<User> getAllUsers(int offset, int limit);
	public User authenticateUser(LogIn logIn);

}
