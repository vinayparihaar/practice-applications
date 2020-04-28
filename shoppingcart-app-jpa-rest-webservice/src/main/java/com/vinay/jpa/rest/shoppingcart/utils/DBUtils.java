package com.vinay.jpa.rest.shoppingcart.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtils {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY=getEntityManagerFactory();
	
	public static EntityManagerFactory getEntityManagerFactory()
	{
		if(ENTITY_MANAGER_FACTORY==null)
		{
			return Persistence.createEntityManagerFactory("UsersDetailsDB");
		}
		return ENTITY_MANAGER_FACTORY;
	}

}
