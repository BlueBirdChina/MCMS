package com.core.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import com.core.model.User;
import com.core.service.CoreManager;
import com.core.util.ServletUtils;

/**
 * <p>
 * Votes if any {@link ConfigAttribute#getAttribute()} starts with a prefix
 * indicating that it is a role. The default prefix string is <Code>ROLE_</code>
 * , but this may be overriden to any value. It may also be set to empty, which
 * means that essentially any attribute will be voted on. As described further
 * below, the effect of an empty prefix may not be quite desireable.
 * </p>
 * 
 * <p>
 * Abstains from voting if no configuration attribute commences with the role
 * prefix. Votes to grant access if there is an exact matching
 * {@link net.sf.acegisecurity.GrantedAuthority} to a
 * <code>ConfigAttribute</code> starting with the role prefix. Votes to deny
 * access if there is no exact matching <code>GrantedAuthority</code> to a
 * <code>ConfigAttribute</code> starting with the role prefix.
 * </p>
 * 
 * <p>
 * All comparisons and prefixes are case sensitive.
 * </p>
 *
 */
public class MyAccessDecisionVoterImpl implements AccessDecisionVoter<Object> {

	@Autowired
	private CoreManager coreManager;

	private String rolePrefix = ""; // PERM_

	/**
	 * Allows the default role prefix of <code>ROLE_</code> to be overriden. May
	 * be set to an empty value, although this is usually not desireable.
	 *
	 * @param rolePrefix
	 *            the new prefix
	 */
	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}

	public String getRolePrefix() {
		return rolePrefix;
	}

	public boolean supports(ConfigAttribute attribute) {
		// if ((attribute.getAttribute() != null) &&
		// attribute.getAttribute().startsWith(getRolePrefix())) {
		// return true;
		// } else {
		// return false;
		// }
		return true;
	}

	/**
	 *
	 * @param clazz
	 *            the secure object
	 *
	 * @return always <code>true</code>
	 */
	public boolean supports(Class clazz) {
		return true;
	}

	public int vote(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes) {
		if (authentication == null
				&& authentication instanceof AnonymousAuthenticationToken)
			return ACCESS_ABSTAIN;

		if (!(object instanceof FilterInvocation))
			return ACCESS_ABSTAIN;

		FilterInvocation fi = (FilterInvocation) object;

		HttpServletRequest request = (HttpServletRequest) fi.getRequest();

		if (ServletUtils.isPublicResource(request))
			return ACCESS_GRANTED;

		if (ServletUtils.isStaticResource(request))
			return ACCESS_GRANTED;

		Object principal = authentication.getPrincipal();
		if (!(principal instanceof User)) {
			return ACCESS_ABSTAIN;
		}
		if (request.getServletPath().equals("/admin")) {
			return ACCESS_GRANTED;
		} else {
			User user = (User) principal;
			if (coreManager.checkAccess(user.getUsername(),
					request.getServletPath())) {
				return ACCESS_GRANTED;
			} else {
				return ACCESS_DENIED;
			}
		}
	}
}
