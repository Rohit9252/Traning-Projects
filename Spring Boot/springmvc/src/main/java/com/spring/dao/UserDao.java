package com.spring.dao;

import javax.persistence.EntityManager;


import org.springframework.stereotype.Repository;

import com.spring.user.User;
import com.spring.util.EmUtil;

@Repository
public class UserDao {

	public int saveUser(User user) {

		EntityManager em = EmUtil.provideEntityManager();
		em.getTransaction().begin();

		em.persist(user);

		em.getTransaction().commit();

		em.close();
		
		return 1;

	}

}
