package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.SystemConfigDao;
import com.core.model.SystemConfig;

@Service
@Transactional
public class SystemConfigManagerImpl implements SystemConfigManager {

	@Autowired
	private SystemConfigDao dao;

	public void saveSystemConfig(final SystemConfig systemConfig) {
		dao.saveSystemConfig(systemConfig);
	}

	public void deleteSystemConfig(final SystemConfig systemConfig) {
		dao.deleteSystemConfig(systemConfig);
	}

	public SystemConfig retrieveSystemConfig() {
		return dao.retrieveSystemConfig();
	}
}
