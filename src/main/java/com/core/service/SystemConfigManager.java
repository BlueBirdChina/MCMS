package com.core.service;

import com.core.model.SystemConfig;

public interface SystemConfigManager {

	public void saveSystemConfig(SystemConfig systemConfig);

	public void deleteSystemConfig(SystemConfig systemConfig);

	public SystemConfig retrieveSystemConfig();

}