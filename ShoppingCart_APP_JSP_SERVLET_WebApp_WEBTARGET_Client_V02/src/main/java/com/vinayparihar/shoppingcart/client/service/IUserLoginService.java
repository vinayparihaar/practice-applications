package com.vinayparihar.shoppingcart.client.service;
/**
 * @author VinayParihar
 * @date May 31, 2020 @time 5:40:39 PM
 */

import com.vinayparihar.shoppingcart.client.bean.Login;
import com.vinayparihar.shoppingcart.client.bean.User;


public interface IUserLoginService {
	
	public User loginUser(Login login);

}
