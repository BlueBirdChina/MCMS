package com.core.service;

import com.core.model.Role;

public interface RoleManager {

	public void saveRole(Role role);

	public void deleteRole(Role role);

	public Role retrieveRoleByRoleName(String roleName);

}