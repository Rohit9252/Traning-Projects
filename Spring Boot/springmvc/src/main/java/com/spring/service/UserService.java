package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDao;
import com.spring.user.User;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	public int createUser(User user) {

		return this.userdao.saveUser(user);

	}

}
