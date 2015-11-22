package com.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ObjectDaoImpl implements ObjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public <T> List<T> find(String queryString) throws DataAccessException {
		return find(queryString, (Object[]) null);
	}

	public <T> List<T> find(String queryString, Object value)
			throws DataAccessException {
		return find(queryString, new Object[] { value });
	}

	public <T> List<T> find(String queryString, Class<T> requiredType,
			final Object[] values) {
		return find(queryString, values);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> find(final String queryString, final Object[] values) {
		Session session = getSession();
		try {

			Query query = session.createQuery(queryString);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			}
			return query.list();
		} finally {

		}
	}
}
