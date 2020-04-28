package com.vinay.jpa.rest.shoppingcart.dao;

import com.vinay.jpa.rest.shoppingcart.model.UserDetails;

public interface IUserLogInDAO {

	public UserDetails getUserbyEmail(String email);

}
