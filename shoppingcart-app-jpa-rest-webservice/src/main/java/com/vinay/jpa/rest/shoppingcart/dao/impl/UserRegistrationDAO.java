package com.vinay.jpa.rest.shoppingcart.dao.impl;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.jpa.rest.shoppingcart.dao.IUserRegistrationDAO;
import com.vinay.jpa.rest.shoppingcart.exceptions.InvalidInputException;
import com.vinay.jpa.rest.shoppingcart.model.UserDetails;
import com.vinay.jpa.rest.shoppingcart.utils.DBUtils;

public class UserRegistrationDAO implements IUserRegistrationDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserRegistrationDAO.class);
	private EntityManager entityManager;

	@Override
	public boolean createUser(UserDetails userDetails) {
		try {
			LOGGER.debug("Entered createUser. ");
			entityManager = DBUtils.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			entityManager.persist(userDetails);

			entityManager.getTransaction().commit();
			LOGGER.debug("Saved data to database from createUser. ");

		} catch (Exception exception) {
			LOGGER.error("Exception occured in createUser. " + exception);
			throw new InvalidInputException("Invalid input. ");

		} finally {
			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in createUser. ");
			}
		}
		return true;
	}

	@Override
	public boolean ifUserExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
