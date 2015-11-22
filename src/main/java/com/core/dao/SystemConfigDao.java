package com.core.dao;

import com.core.model.SystemConfig;

public interface SystemConfigDao {

	public void saveSystemConfig(SystemConfig systemConfig);

	public void deleteSystemConfig(SystemConfig systemConfig);

	public SystemConfig retrieveSystemConfig();

}