package com.vinayparihar.shoppingcart.client.utils;

/**
 * @author VinayParihar
 * @date May 31, 2020 @time 5:40:39 PM
 */

public class Utils {
	
	public static boolean isEmpty(String string)
	{
		if(string==null || string.trim().length()<=0)
			return true;
		else
			return false;
	}

}
