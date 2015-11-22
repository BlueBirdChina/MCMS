package com.core.dao;

import org.springframework.stereotype.Repository;

import com.core.model.RoleMenu;

@Repository
public class RoleMenuDaoImpl extends ObjectDaoImpl implements RoleMenuDao {

	public void saveRoleMenu(final RoleMenu roleMenu) {
		getSession().saveOrUpdate(roleMenu);
	}

	public void deleteRoleMenu(final RoleMenu roleMenu) {
		getSession().delete(roleMenu);
	}

}
