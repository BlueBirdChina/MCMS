package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.RoleMenuDao;
import com.core.model.RoleMenu;

@Service
@Transactional
public class RoleMenuManagerImpl implements RoleMenuManager {

	@Autowired
	private RoleMenuDao dao;

	public void saveRoleMenu(RoleMenu roleMenu) {
		dao.saveRoleMenu(roleMenu);
	}

	public void deleteRoleMenu(RoleMenu roleMenu) {
		dao.deleteRoleMenu(roleMenu);
	}

}
