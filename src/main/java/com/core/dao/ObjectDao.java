package com.core.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

public interface ObjectDao {

	public Session getSession();

	public <T> List<T> find(String queryString) throws DataAccessException;

	public <T> List<T> find(String queryString, Object value)
			throws DataAccessException;

	public <T> List<T> find(String queryString, Class<T> requiredType,
			Object[] values);

}