package com.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.model.SystemConfig;
import com.core.model.SystemConfigImpl;

@Repository
public class SystemConfigDaoImpl extends ObjectDaoImpl implements
		SystemConfigDao {

	public void saveSystemConfig(final SystemConfig systemConfig) {
		getSession().saveOrUpdate(systemConfig);
	}

	public void deleteSystemConfig(final SystemConfig systemConfig) {
		getSession().delete(systemConfig);
	}

	public SystemConfig retrieveSystemConfig() {
		String query = "from " + SystemConfigImpl.class.getName();
		List<SystemConfig> systemConfigs = find(query);
		if (systemConfigs.size() > 0)
			return systemConfigs.get(0);

		return null;
	}

}
