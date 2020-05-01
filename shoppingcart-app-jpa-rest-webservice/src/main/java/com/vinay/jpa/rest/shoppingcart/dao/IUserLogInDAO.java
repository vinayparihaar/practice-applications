package com.vinay.jpa.rest.shoppingcart.dao;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import java.util.List;

import com.vinay.jpa.rest.shoppingcart.model.UserDetails;

public interface IUserLogInDAO {

	public UserDetails getUserbyEmail(String email);
	public List<UserDetails> getAllUsers(int offset, int limit);

}
