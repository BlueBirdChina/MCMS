package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.UserDao;
import com.core.model.User;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDao dao;

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	public void saveUser(User user) {
		dao.saveUser(user);
	}

	public void createUser(User user) {
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),
				null));
		dao.saveUser(user);
	}

	public void deleteUser(User user) {
		dao.deleteUser(user);
	}

	public User retrieveUserByUserName(String userName) {
		return dao.retrieveUserByUserName(userName);
	}
}
