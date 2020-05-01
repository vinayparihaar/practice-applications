package com.vinay.jpa.rest.shoppingcart.utils;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

public class Utils {

	public static boolean isEmpty(String string) {

		if (string == null || string.trim().length() <= 0)

			return true;
		else
			return false;
	}

}
