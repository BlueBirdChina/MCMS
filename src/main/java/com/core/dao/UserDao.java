package com.core.dao;

import com.core.model.User;

public interface UserDao {

	public void saveUser(User user);

	public void deleteUser(User user);

	public User retrieveUserByUserName(String userName);

	public User retrieveUsers();
}