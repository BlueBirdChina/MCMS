package com.core.service;

import java.util.HashMap;

import com.core.model.Menu;

public interface CoreManager {

	public void initSystem();

	public HashMap<String, Menu> retrieveMenusByUserName(String userName);

	public boolean checkAccess(String userName, String action);

	public String generateMenuDom();
}