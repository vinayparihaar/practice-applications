/**
 * 
 */
package com.vinayparihar.shoppingcart.client.service.impl;

/**
 * @author VinayParihar
 * @date Apr 29, 2020 @time 3:24:06 PM
 */

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinayparihar.shoppingcart.client.bean.Login;
import com.vinayparihar.shoppingcart.client.bean.User;

public class UserLoginService {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserLoginService.class);
	private User user;

	public User loginUser(Login login) {

		LOGGER.debug("Entered loginUser. ");

		Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
		// WebTarget webTarget =
		// client.target("http://localhost:8080/userregrestwebservice/webapi/users");
		// (or)
		WebTarget webTarget = client.target("http://localhost:8010/shoppingcart/webapi").path("login");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));
		if (response != null && (response.getStatus() == 200 || response.getStatus() == 201)) {
			user = response.readEntity(User.class);

			if (user != null) {
				LOGGER.debug("Retriving User data. ");

				LOGGER.debug("First Name : " + user.getFirstName());
				LOGGER.debug("Last Name : " + user.getLastName());
				LOGGER.debug("Email : " + user.getEmail());

				LOGGER.debug("Phone : " + user.getPhone());
				LOGGER.debug("Password : " + user.getPassword());
				LOGGER.debug("Address Line 1 : " + user.getAddress().getLineOne());
				LOGGER.debug("Address Line 2 : " + user.getAddress().getLineTwo());
				LOGGER.debug("City : " + user.getAddress().getCity());
				LOGGER.debug("State : " + user.getAddress().getState());
				LOGGER.debug("Zipcode : " + user.getAddress().getZipcode());
				LOGGER.debug("Country : " + user.getAddress().getCountry());

				LOGGER.debug("User successfully Loggedin. ");
				return user;
			}
		}
		return null;

	}

}

/*
 * public class UserLoginService { private final static Logger LOGGER =
 * LoggerFactory.getLogger(UserLoginService.class); private User user;
 * 
 * public User loginUser(Login login) {
 * 
 * LOGGER.debug("Entered loginUser. "); if (login != null) {
 * LOGGER.debug("Login Object is not empty or null. "); Client client =
 * ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class)); //
 * WebTarget webTarget = //
 * client.target("http://localhost:8080/userregrestwebservice/webapi/users"); //
 * (or) WebTarget webTarget =
 * client.target("http://localhost:8010/shoppingcart/webapi").path("login");
 * Invocation.Builder invocationBuilder =
 * webTarget.request(MediaType.APPLICATION_JSON); user =
 * invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON),
 * User.class);
 * 
 * if (user != null) { LOGGER.debug("Retriving User data. ");
 * System.out.println(user.getFirstName());
 * System.out.println(user.getLastName()); System.out.println(user.getEmail());
 * System.out.println(user.getPhone()); System.out.println(user.getPassword());
 * System.out.println(user.getAddress().getLineOne());
 * System.out.println(user.getAddress().getLineTwo());
 * System.out.println(user.getAddress().getCity());
 * System.out.println(user.getAddress().getState());
 * System.out.println(user.getAddress().getZipcode());
 * System.out.println(user.getAddress().getCountry());
 * LOGGER.debug("User successfully Loggedin. "); return user; } }
 * 
 * return null; }
 * 
 * }
 */


/*
 * public boolean loginUser(Login login) { if (login != null) { Client client =
 * ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class)); //
 * WebTarget webTarget = //
 * client.target("http://localhost:8080/userregrestwebservice/webapi/users"); //
 * (or) WebTarget webTarget =
 * client.target("http://localhost:8010/shoppingcart/webapi").path("login");
 * Invocation.Builder invocationBuilder =
 * webTarget.request(MediaType.APPLICATION_JSON); Response response =
 * invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));
 * 
 * System.out.println(response.getStatus());
 * System.out.println(response.getHeaders());
 * System.out.println(response.readEntity(String.class)); } else { return false;
 * } return true; }
 */
