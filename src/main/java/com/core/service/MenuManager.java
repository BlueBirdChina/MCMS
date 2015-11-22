package com.core.service;

import java.util.List;

import com.core.model.Menu;

public interface MenuManager {

	public void saveMenu(Menu menu);

	public void deleteRole(Menu menu);

	public List<Menu> retrieveMenus();

	public Menu retrieveRootMenu();
}