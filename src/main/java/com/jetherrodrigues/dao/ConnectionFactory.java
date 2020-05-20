package com.jetherrodrigues.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class ConnectionFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql-whizlabs");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
