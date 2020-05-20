package com.jetherrodrigues.executions;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jetherrodrigues.dao.ConnectionFactory;
import com.jetherrodrigues.domain.Client;

public class JpqlNamedParameter {
	
	public static void main(String[] args) {
		
		final EntityManager em = ConnectionFactory.getEntityManager(); 
		
		final String jpql = "select c from Client c where c.id = :id";
				
		final TypedQuery<Client> query = em.createQuery(jpql, Client.class);
		query.setParameter("id", 1L);
		
		final Client client = query.getSingleResult();
		
		System.out.println(client);
	}
}
