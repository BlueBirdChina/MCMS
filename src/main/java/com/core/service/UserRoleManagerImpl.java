package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.UserRoleDao;
import com.core.model.UserRole;

@Service
@Transactional
public class UserRoleManagerImpl implements UserRoleManager {

	@Autowired
	private UserRoleDao dao;

	public void saveUserRole(UserRole userRole) {
		dao.saveUserRole(userRole);
	}

	public void deleteUserRole(UserRole userRole) {
		dao.deleteUserRole(userRole);
	}

}
