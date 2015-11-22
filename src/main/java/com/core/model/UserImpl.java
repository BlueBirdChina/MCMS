package com.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "com.jx.core.model.UserImpl")
@Table(name = "UserInfo")
public class UserImpl extends ObjectImpl implements UserDetails, User {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, length = 8, nullable = false)
	private String userName;

	@Column(length = 512)
	private String password;

	@Column(length = 256)
	private String simpleName;

	@Column(length = 10)
	private String gender;

	@Temporal(TemporalType.TIMESTAMP)
	private Date onBoardDate;

	@Type(type = "yes_no")
	private boolean enabled = true;

	@Column(length = 64)
	private String email;

	@Column(length = 64)
	private String fax;

	@Column(length = 64)
	private String officePhone;

	@Column(length = 64)
	private String homePhone;

	@Column(length = 64)
	private String telePhone;

	@OneToMany(targetEntity = UserRoleImpl.class, fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "userOid")
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	@Transient
	private Collection<GrantedAuthority> authorities;

	@Type(type = "yes_no")
	private boolean accountNonExpired = true;

	@Type(type = "yes_no")
	private boolean accountNonLocked = true;

	@Type(type = "yes_no")
	private boolean credentialsNonExpired = true;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getOnBoardDate() {
		return onBoardDate;
	}

	public void setOnBoardDate(Date onBoardDate) {
		this.onBoardDate = onBoardDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRole) {
		this.userRoles = userRole;
	}

	public void addUserRole(UserRole userRole) {
		this.userRoles.add(userRole);
	}

	public void removeUserRole(UserRole userRole) {
		this.userRoles.remove(userRole);
	}

	public void clearUserRole() {
		this.userRoles.clear();
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public List<Role> getRoles() {
		List<Role> result = new ArrayList<Role>();

		for (UserRole userRole : userRoles) {
			result.add(userRole.getRole());
		}

		return result;
	}

	public String getUsername() {
		return this.userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

}
