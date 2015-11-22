package com.core.service;

import com.core.model.User;

public interface UserManager {

	public void saveUser(User user);

	public void createUser(User user);

	public void deleteUser(User user);

	public User retrieveUserByUserName(String userName);

}