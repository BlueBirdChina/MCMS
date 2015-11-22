package com.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "com.jx.core.model.RoleMenuImpl")
@Table(name = "Role_Menu")
public class RoleMenuImpl extends ObjectImpl implements RoleMenu {

	@ManyToOne(targetEntity = MenuImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "menuOid")
	private Menu menu;

	@ManyToOne(targetEntity = RoleImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "roleOid")
	private Role role;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
