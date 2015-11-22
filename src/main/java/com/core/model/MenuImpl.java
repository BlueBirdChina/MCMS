package com.core.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

@Entity(name = "com.jx.core.model.MenuImpl")
@Table(name = "Menu")
public class MenuImpl extends ObjectImpl implements Menu {

	@Column(length = 128)
	private String name;

	@Column(length = 512)
	private String action;

	@ManyToOne(targetEntity = MenuImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "parentMenuOid")
	private Menu parentMenu;

	@OneToMany(targetEntity = MenuImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "oid")
	private Set<Menu> childrenMenus = new HashSet<Menu>();

	@OneToMany(targetEntity = RoleImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "roleOid")
	private Set<RoleMenu> menuRoles = new HashSet<RoleMenu>();

	@Type(type = "yes_no")
	private boolean isRoot = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public Set<RoleMenu> getMenuRoles() {
		return menuRoles;
	}

	public void setMenuRoles(Set<RoleMenu> menuRole) {
		this.menuRoles = menuRole;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public Set<Menu> getChildrenMenus() {
		return childrenMenus;
	}

	public void setChildrenMenus(Set<Menu> childrenMenus) {
		this.childrenMenus = childrenMenus;
	}

}
