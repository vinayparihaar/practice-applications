package com.vinay.jpa.rest.shoppingcart.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.jpa.rest.shoppingcart.dao.IUserLogInDAO;
import com.vinay.jpa.rest.shoppingcart.exceptions.UserNotFoundException;
import com.vinay.jpa.rest.shoppingcart.model.UserDetails;
import com.vinay.jpa.rest.shoppingcart.utils.DBUtils;

public class UserLogInDAO implements IUserLogInDAO {

	private final static Logger LOGGER= LoggerFactory.getLogger(UserLogInDAO.class);
	private EntityManager entityManager;
	private UserDetails userDetails;

	@Override
	public UserDetails getUserbyEmail(String email) {

		try {
			LOGGER.debug("Entered createUser. ");
			entityManager = DBUtils.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("SELECT ud FROM UserDetails ud WHERE ud.email = :email");
			query.setParameter("email", email);
			userDetails = (UserDetails) query.getSingleResult();
			entityManager.getTransaction().commit();
			LOGGER.debug("Retrived data from database. ");

		} catch (Exception exception) {
			LOGGER.error("Exception occured in createUser. " + exception);
			throw new  UserNotFoundException("User with "+email+" not found. ");

		} finally {
			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in createUser. ");
			}

		}
		return userDetails;

	}

}
