package com.vinay.jpa.rest.shoppingcart.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1692057825589603224L;

	public UserNotFoundException(String message)
	{
		super(message);
		
	}

}
