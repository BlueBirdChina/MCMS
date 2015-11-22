package com.core.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.model.Menu;
import com.core.model.MenuImpl;
import com.core.model.Role;
import com.core.model.RoleImpl;
import com.core.model.RoleMenu;
import com.core.model.RoleMenuImpl;
import com.core.model.SystemConfig;
import com.core.model.SystemConfigImpl;
import com.core.model.User;
import com.core.model.UserImpl;
import com.core.model.UserRole;
import com.core.model.UserRoleImpl;

@Service
@Transactional
public class CoreManagerImpl implements CoreManager {

	@Autowired
	private UserManager userManager;

	@Autowired
	private RoleManager roleManager;

	@Autowired
	private UserRoleManager userRoleManager;

	@Autowired
	private MenuManager menuManager;

	@Autowired
	private RoleMenuManager roleMenuManager;

	@Autowired
	private SystemConfigManager systemConfigManager;

	public void initSystem() {
		SystemConfig systemConfig = systemConfigManager.retrieveSystemConfig();
		if (null == systemConfig) {
			User admin = new UserImpl();
			admin.setUsername("Admin");
			admin.setSimpleName("Admin");
			admin.setPassword("123456");
			userManager.createUser(admin);

			Menu menu = new MenuImpl();
			menu.setName("管理员");
			menu.setAction("/Welcome");
			menuManager.saveMenu(menu);

			Role role = new RoleImpl();
			role.setRoleName("超级管理员");
			role.setDescription("超级管理员");
			role.setSupAdmin(true);
			roleManager.saveRole(role);

			RoleMenu roleMenu = new RoleMenuImpl();
			roleMenu.setRole(role);
			roleMenu.setMenu(menu);
			roleMenuManager.saveRoleMenu(roleMenu);

			UserRole userRole = new UserRoleImpl();
			userRole.setUser(admin);
			userRole.setRole(role);
			userRoleManager.saveUserRole(userRole);

			systemConfig = new SystemConfigImpl();
			systemConfig.setInited(true);
			systemConfigManager.saveSystemConfig(systemConfig);
		}
	}

	public HashMap<String, Menu> retrieveMenusByUserName(String userName) {
		HashMap<String, Menu> menuMap = new HashMap<String, Menu>();

		User user = userManager.retrieveUserByUserName(userName);
		Set<UserRole> userRoles = user.getUserRoles();
		Iterator<UserRole> userRoleIT = userRoles.iterator();
		while (userRoleIT.hasNext()) {
			UserRole userRole = userRoleIT.next();
			Role role = userRole.getRole();
			Set<RoleMenu> roleMenus = role.getRoleMenus();
			Iterator<RoleMenu> roleMenuIT = roleMenus.iterator();
			while (roleMenuIT.hasNext()) {
				RoleMenu roleMenu = roleMenuIT.next();
				Menu menu = roleMenu.getMenu();
				if (!menuMap.containsKey(menu.getOid())) {
					menuMap.put(menu.getOid(), menu);
				}
			}
		}
		return menuMap;
	}

	public boolean checkAccess(String userName, String action) {

		User user = userManager.retrieveUserByUserName(userName);
		Set<UserRole> userRoles = user.getUserRoles();
		Iterator<UserRole> userRoleIT = userRoles.iterator();
		while (userRoleIT.hasNext()) {
			UserRole userRole = userRoleIT.next();
			Role role = userRole.getRole();
			if (role.isSupAdmin()) {
				return true;
			}
			Set<RoleMenu> roleMenus = role.getRoleMenus();
			Iterator<RoleMenu> roleMenuIT = roleMenus.iterator();
			while (roleMenuIT.hasNext()) {
				RoleMenu roleMenu = roleMenuIT.next();
				Menu menu = roleMenu.getMenu();
				if (menu.getAction().equals(action)) {
					return true;
				}
			}
		}

		return false;
	}
	
	public String generateMenuDom(){
		Menu rootMenu = menuManager.retrieveRootMenu();
		Set<Menu> menus = rootMenu.getChildrenMenus();
		Iterator<Menu> menuIT = menus.iterator();
		while (menuIT.hasNext()) {
			Menu menu = menuIT.next();
			System.out.println(menu.getName());
			
		}
		return "";
	}
}