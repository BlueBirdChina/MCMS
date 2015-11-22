package com.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.model.User;
import com.core.model.UserImpl;

@Repository
public class UserDaoImpl extends ObjectDaoImpl implements UserDao {

	public void saveUser(final User user) {
		getSession().saveOrUpdate(user);
	}

	public void deleteUser(final User user) {
		getSession().delete(user);
	}

	public User retrieveUserByUserName(String userName) {
		String query = "from " + UserImpl.class.getName()
				+ " as u where u.userName = ?";
		List<User> users = find(query, userName);
		if (users.size() > 0)
			return users.get(0);

		return null;
	}

	public User retrieveUsers() {
		String query = "from " + UserImpl.class.getName();
		List<User> users = find(query);

		return (User) users;
	}

}
