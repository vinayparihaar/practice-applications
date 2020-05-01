package com.vinay.jpa.rest.shoppingcart.dao.impl;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinay.jpa.rest.shoppingcart.dao.IUserLogInDAO;
import com.vinay.jpa.rest.shoppingcart.exceptions.UserNotFoundException;
import com.vinay.jpa.rest.shoppingcart.model.UserDetails;
import com.vinay.jpa.rest.shoppingcart.utils.DBUtils;
import com.vinay.jpa.rest.shoppingcart.utils.Utils;

public class UserLogInDAO implements IUserLogInDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserLogInDAO.class);
	private EntityManager entityManager;
	private UserDetails userDetails;
	private List<UserDetails> listOfUsers;

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
			throw new UserNotFoundException("User with " + email + " not found. ");

		} finally {
			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in createUser. ");
			}
		}
		return userDetails;

	}

	@Override
	public List<UserDetails> getAllUsers(int offset, int limit) {
		listOfUsers = new ArrayList<UserDetails>();
		try {
			LOGGER.debug("Entered getAllUsers. ");
			entityManager = DBUtils.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("SELECT ud FROM UserDetails ud", UserDetails.class);

			if (offset >= 0) {
				query.setFirstResult(offset);
			}
			if (limit >= 0) {
				query.setMaxResults(limit);
			}
			listOfUsers = (List<UserDetails>) query.getResultList();

			entityManager.getTransaction().commit();
			LOGGER.debug("Retrived All Users from database. ");

		} catch (Exception exception) {
			LOGGER.error("Exception occured in getAllUsers. " + exception);
			throw new UserNotFoundException("No records found. "+ exception);

		} finally {
			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in getAllUsers. ");
			}

		}
		return listOfUsers;

	}

}
