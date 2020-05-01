package com.vinayparihar.shoppingcart.client.utils;

/**
 * @author VinayParihar
 * @date Apr 29, 2020 @time 2:27:13 PM 
 */

/**
 * @author Vinay Parihar
 *
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
