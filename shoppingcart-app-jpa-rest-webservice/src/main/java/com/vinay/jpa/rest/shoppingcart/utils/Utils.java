package com.vinay.jpa.rest.shoppingcart.utils;

public class Utils {

	public static boolean isEmpty(String string) {

		if (string == null || string.trim().length() <= 0)

			return true;
		else
			return false;
	}

}
