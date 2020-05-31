package com.vinayparihar.shoppingcart.client.service.impl;

/**
 * @author VinayParihar
 * @date May 31, 2020 @time 5:40:39 PM
 */

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinayparihar.shoppingcart.client.bean.User;
import com.vinayparihar.shoppingcart.client.service.IUserRegistrationService;

public class UserRegistrationService implements IUserRegistrationService {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);
	
	public boolean registerUser(User user) {

		LOGGER.debug("Entered registerUser. ");

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8010/shoppingcart/webapi").path("register");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = builder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

		if (response != null) {
			
			System.out.println(response.getStatus());
			System.out.println(response.getHeaders());
			System.out.println(response.readEntity(String.class));
			
			if (response.getStatus() == 201 || response.getStatus() == 200) {
				
				LOGGER.debug("User successfully registered. ");
				return true;
			}
		}
		return false;
	}
}



/*
 * public boolean registerUser(User user) {
 * 
 * LOGGER.debug("Entered registerUser. "); Client client =
 * ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
 * 
 * // WebTarget webTarget = //
 * client.target("http://localhost:8080/userregrestwebservice/webapi/register");
 * 
 * // (or)
 * 
 * WebTarget webTarget =
 * client.target("http://localhost:8010/shoppingcart/webapi").path("register");
 * Invocation.Builder invocationBuilder =
 * webTarget.request(MediaType.APPLICATION_JSON); response =
 * invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
 * 
 * 
 * // if (response != null && (response.getStatus() == 201 ||
 *  response.getStatus() == 200)) // { // }
 * 
 * 
 * if (response != null) { System.out.println(response.getStatus());
 * System.out.println(response.getHeaders());
 * System.out.println(response.readEntity(String.class));
 * if(response.getStatus() == 201 || response.getStatus() == 200) {
 * LOGGER.debug("User successfully registered."); return true; } } return false;
 * }
 */
 
