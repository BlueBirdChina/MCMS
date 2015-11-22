package com.core.dao;

import java.util.List;

import com.core.model.Role;

public interface RoleDao {

	public void saveRole(Role role);

	public void deleteRole(Role role);

	public List<Role> retrieveRoles();

	public Role retrieveRoleByRoleName(String roleName);

}