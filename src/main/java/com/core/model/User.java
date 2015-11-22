package com.core.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public interface User extends Object, UserDetails {

	public String getPassword();

	public void setPassword(String password);

	public String getSimpleName();

	public void setSimpleName(String simpleName);

	public String getGender();

	public void setGender(String gender);

	public Date getOnBoardDate();

	public void setOnBoardDate(Date onBoardDate);

	public boolean isEnabled();

	public void setEnabled(boolean enabled);

	public String getEmail();

	public void setEmail(String email);

	public String getFax();

	public void setFax(String fax);

	public String getOfficePhone();

	public void setOfficePhone(String officePhone);

	public String getHomePhone();

	public void setHomePhone(String homePhone);

	public String getTelePhone();

	public void setTelePhone(String telePhone);

	public Set<UserRole> getUserRoles();

	public void setUserRoles(Set<UserRole> userRole);

	public void addUserRole(UserRole userRole);

	public void removeUserRole(UserRole userRole);

	public void clearUserRole();

	public Collection<GrantedAuthority> getAuthorities();

	public void setAuthorities(Collection<GrantedAuthority> authorities);

	public boolean isAccountNonExpired();

	public void setAccountNonExpired(boolean accountNonExpired);

	public boolean isAccountNonLocked();

	public void setAccountNonLocked(boolean accountNonLocked);

	public boolean isCredentialsNonExpired();

	public void setCredentialsNonExpired(boolean credentialsNonExpired);

	public List<Role> getRoles();

	public String getUsername();

	public void setUsername(String userName);
}