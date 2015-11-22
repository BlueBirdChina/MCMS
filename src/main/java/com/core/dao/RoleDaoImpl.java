package com.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.model.Role;
import com.core.model.RoleImpl;
import com.core.model.UserImpl;

@Repository
public class RoleDaoImpl extends ObjectDaoImpl implements RoleDao {

	/* (non-Javadoc)
	 * @see com.jx.core.dao.RoleDao#saveRole(com.jx.core.model.Role)
	 */
	public void saveRole(final Role role) {
		getSession().saveOrUpdate(role);
	}

	/* (non-Javadoc)
	 * @see com.jx.core.dao.RoleDao#deleteRole(com.jx.core.model.Role)
	 */
	public void deleteRole(final Role role) {
		getSession().delete(role);
	}

	/* (non-Javadoc)
	 * @see com.jx.core.dao.RoleDao#retrieveRoles()
	 */
	public List<Role> retrieveRoles() {
		String query = "from " + UserImpl.class.getName();
		List<Role> roles = find(query);

		return roles;
	}

	/* (non-Javadoc)
	 * @see com.jx.core.dao.RoleDao#retrieveRoleByRoleName(java.lang.String)
	 */
	public Role retrieveRoleByRoleName(String roleName) {
		String query = "from " + RoleImpl.class.getName()
				+ " as u where u.roleName = ?";
		List<Role> roles = find(query, roleName);
		if (roles.size() > 0)
			return roles.get(0);

		return null;
	}

}
