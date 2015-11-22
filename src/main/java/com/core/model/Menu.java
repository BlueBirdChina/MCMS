package com.core.model;

import java.util.Set;

public interface Menu extends Object {

	public String getName();

	public void setName(String name);

	public String getAction();

	public void setAction(String action);

	public Menu getParentMenu();

	public void setParentMenu(Menu parentMenu);

	public Set<RoleMenu> getMenuRoles();

	public void setMenuRoles(Set<RoleMenu> menuRole);
	
	public boolean isRoot();

	public void setRoot(boolean isRoot);
	
	public Set<Menu> getChildrenMenus();

	public void setChildrenMenus(Set<Menu> childrenMenus);
}