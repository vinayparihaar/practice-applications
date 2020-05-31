package com.vinayparihar.shoppingcart.client.bean;

/**
 * @author VinayParihar
 * @date May 31, 2020 @time 5:40:39 PM
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "email", "password" })
public class Login {

	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Login() {
	}

	/**
	 *
	 * @param password
	 * @param email
	 */
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

}
