package com.vinayparihar.shoppingcart.client.service;
/**
 * @author VinayParihar
 * @date May 1, 2020 @time 1:43:11 PM 
 */

import com.vinayparihar.shoppingcart.client.bean.Login;
import com.vinayparihar.shoppingcart.client.bean.User;


public interface IUserLoginService {
	
	public User loginUser(Login login);

}
