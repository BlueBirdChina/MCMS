package com.core.dao;

import java.util.List;

import com.core.model.Menu;

public interface MenuDao {

	public void saveMenu(Menu menu);

	public void deleteMenu(Menu menu);

	public List<Menu> retrieveMenus();

	public Menu retrieveRootMenu();
}