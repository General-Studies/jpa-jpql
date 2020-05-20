package com.jetherrodrigues.executions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jetherrodrigues.dao.ConnectionFactory;
import com.jetherrodrigues.domain.Client;

public class JpqlNamedQuery {
	
	public static void main(String[] args) {
		
		final EntityManager em = ConnectionFactory.getEntityManager(); 
		
		final TypedQuery<Client> typedQuery = em.createNamedQuery("findAllClient", Client.class);

		final List<Client> customers = typedQuery.getResultList();

		customers.forEach(System.out::println);
	}
}
