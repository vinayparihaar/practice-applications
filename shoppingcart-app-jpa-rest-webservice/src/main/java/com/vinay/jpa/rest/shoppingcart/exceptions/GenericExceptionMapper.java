/**
 * 
 */
package com.vinay.jpa.rest.shoppingcart.exceptions;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:36:49 PM 
 */

import com.vinay.jpa.rest.shoppingcart.bean.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable throwableEx) {
		ErrorMessage errorMessage = new ErrorMessage(throwableEx.getMessage(), 500, "https://www.google.com/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
