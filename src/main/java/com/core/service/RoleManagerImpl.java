package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.RoleDao;
import com.core.model.Role;

@Service
@Transactional
public class RoleManagerImpl implements RoleManager {

	@Autowired
	private RoleDao dao;

	public void saveRole(Role role) {
		dao.saveRole(role);
	}

	public void deleteRole(Role role) {
		dao.deleteRole(role);
	}

	public Role retrieveRoleByRoleName(String roleName) {
		return dao.retrieveRoleByRoleName(roleName);
	}
}
