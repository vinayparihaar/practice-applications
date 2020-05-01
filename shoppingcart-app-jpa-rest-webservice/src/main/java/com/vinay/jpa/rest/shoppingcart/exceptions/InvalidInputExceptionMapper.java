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
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

	@Override
	public Response toResponse(InvalidInputException invalidInputException) {
		ErrorMessage errorMessage= new ErrorMessage(invalidInputException.getMessage(), 406, "https://www.google.com/");
		return Response.status(Status.NOT_ACCEPTABLE).entity(errorMessage).build();
	
	}
}
