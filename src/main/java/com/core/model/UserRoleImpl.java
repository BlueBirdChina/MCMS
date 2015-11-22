package com.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "com.jx.core.model.UserRoleImpl")
@Table(name = "User_Role")
public class UserRoleImpl extends ObjectImpl implements UserRole {

	@ManyToOne(targetEntity = UserImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "userOid")
	private User user;

	@ManyToOne(targetEntity = RoleImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "roleOid")
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
