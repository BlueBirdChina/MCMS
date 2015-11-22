package com.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.MenuDao;
import com.core.model.Menu;

@Service
@Transactional
public class MenuManagerImpl implements MenuManager {

	@Autowired
	private MenuDao dao;

	public void saveMenu(Menu menu) {
		dao.saveMenu(menu);
	}

	public void deleteRole(Menu menu) {
		dao.deleteMenu(menu);
	}

	public List<Menu> retrieveMenus() {
		return dao.retrieveMenus();
	}

	public Menu retrieveRootMenu() {
		return dao.retrieveRootMenu();
	}

}
