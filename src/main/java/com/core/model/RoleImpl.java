package com.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

@Entity(name = "com.jx.core.model.RoleImpl")
@Table(name = "Role")
public class RoleImpl extends ObjectImpl implements Role {

	@Column(length = 128)
	private String roleName;

	@Column(length = 512)
	private String description;

	@Type(type = "yes_no")
	private boolean enabled = true;

	@Type(type = "yes_no")
	private boolean supAdmin = false;

	@OneToMany(targetEntity = UserRoleImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "roleOid")
	private Set<UserRole> roleUsers = new HashSet<UserRole>();

	@OneToMany(targetEntity = RoleMenuImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "roleOid")
	private Set<RoleMenu> roleMenus = new HashSet<RoleMenu>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<UserRole> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(Set<UserRole> roleUsers) {
		this.roleUsers = roleUsers;
	}

	public void addUserRole(UserRole roleUser) {
		this.roleUsers.add(roleUser);
	}

	public void removeUserRole(UserRole roleUser) {
		this.roleUsers.remove(roleUser);
	}

	public void clearUserRole() {
		this.roleUsers.clear();
	}

	public Set<RoleMenu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(Set<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public void addRoleMenu(RoleMenu roleMenu) {
		this.roleMenus.add(roleMenu);
	}

	public void removeRoleMenu(RoleMenu roleMenu) {
		this.roleMenus.remove(roleMenu);
	}

	public void clearRoleMenu() {
		this.roleMenus.clear();
	}

	public boolean isSupAdmin() {
		return supAdmin;
	}

	public void setSupAdmin(boolean supAdmin) {
		this.supAdmin = supAdmin;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

}
