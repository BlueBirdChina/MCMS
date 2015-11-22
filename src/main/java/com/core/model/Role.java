package com.core.model;

import java.util.Set;

public interface Role extends Object {

	public String getRoleName();

	public void setRoleName(String roleName);

	public String getDescription();

	public void setDescription(String description);

	public Set<UserRole> getRoleUsers();

	public void setRoleUsers(Set<UserRole> roleUsers);

	public void addUserRole(UserRole roleUser);

	public void removeUserRole(UserRole roleUser);

	public void clearUserRole();

	public Set<RoleMenu> getRoleMenus();

	public void setRoleMenus(Set<RoleMenu> roleMenus);

	public void addRoleMenu(RoleMenu roleMenu);

	public void removeRoleMenu(RoleMenu roleMenu);

	public void clearRoleMenu();

	public boolean isSupAdmin();

	public void setSupAdmin(boolean supAdmin);

	public void setEnabled(boolean enabled);

	public boolean isEnabled();

}