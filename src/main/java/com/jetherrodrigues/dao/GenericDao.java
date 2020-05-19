package com.jetherrodrigues.dao;

import javax.persistence.EntityManager;

import com.jetherrodrigues.domain.BaseEntity;

public class GenericDao<T extends BaseEntity> {
	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T findById(final Class<T> clazz, final Long id) {
		return manager.find(clazz, id);
	}

	public T saveOrUpdate(final T obj) {
		try {
			manager.getTransaction().begin();
			if (obj.getId() == null) {
				manager.persist(obj);
			} else {
				manager.merge(obj);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		
		return obj;
	}

	public void remove(final Class<T> clazz, final Long id) {
		T t = findById(clazz, id);
		try {
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
}
