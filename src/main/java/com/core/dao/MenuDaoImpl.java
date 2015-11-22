package com.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.model.Menu;
import com.core.model.MenuImpl;

@Repository
public class MenuDaoImpl extends ObjectDaoImpl implements MenuDao {

	public void saveMenu(final Menu menu) {
		getSession().saveOrUpdate(menu);
	}

	public void deleteMenu(final Menu menu) {
		getSession().delete(menu);
	}

	public List<Menu> retrieveMenus() {
		String query = "from " + MenuImpl.class.getName();
		List<Menu> menus = find(query);

		return menus;
	}

	public Menu retrieveRootMenu() {
		String query = "from " + MenuImpl.class.getName()
				+ " as m where m.isRoot = ?";
		List<Menu> menus = find(query, true);
		if (menus.size() > 0)
			return menus.get(0);

		return null;
	}

}
