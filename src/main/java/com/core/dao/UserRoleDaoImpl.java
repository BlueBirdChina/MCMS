package com.core.dao;

import org.springframework.stereotype.Repository;

import com.core.model.UserRole;

@Repository
public class UserRoleDaoImpl extends ObjectDaoImpl implements UserRoleDao {

	public void saveUserRole(final UserRole userRole) {
		getSession().saveOrUpdate(userRole);
	}

	public void deleteUserRole(final UserRole userRole) {
		getSession().delete(userRole);
	}

}
