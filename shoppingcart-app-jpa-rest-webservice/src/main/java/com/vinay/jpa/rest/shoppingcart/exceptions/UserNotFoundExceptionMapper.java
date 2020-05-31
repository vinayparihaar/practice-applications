package com.vinay.jpa.rest.shoppingcart.exceptions;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import com.vinay.jpa.rest.shoppingcart.bean.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {
	@Override
	public Response toResponse(UserNotFoundException userNotFoundException) {
		ErrorMessage errorMessage = new ErrorMessage(userNotFoundException.getMessage(), 404,
				"https://www.google.com/");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
		
	}

}
