package com.core.security;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.core.model.User;
import com.core.service.RoleManager;
import com.core.service.UserManager;
import com.core.service.UserRoleManager;

public class MyUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private RoleManager roleManager;
	
	@Autowired
	private UserRoleManager userRoleManager;
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("username is " + username);
		User user = null;
		try {
			user = userManager.retrieveUserByUserName(username);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new UsernameNotFoundException(username);
		}
		if (user == null) {
			throw new UsernameNotFoundException(username);
		} else {
			if (!user.isEnabled()) {
				throw new UsernameNotFoundException("User Name not found");
			}
		}
//		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
//
//		user.setAuthorities(result);

		return user;
	}

}