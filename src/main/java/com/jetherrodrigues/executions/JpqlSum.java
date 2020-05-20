package com.jetherrodrigues.executions;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jetherrodrigues.dao.ConnectionFactory;

public class JpqlSum {
	
	public static void main(String[] args) {
		
		final EntityManager em = ConnectionFactory.getEntityManager(); 
		
		final TypedQuery<BigDecimal> typedQuery = em.createNamedQuery("findSumOfAccountMovimentation", BigDecimal.class);

		final BigDecimal sumOfMovimentations = typedQuery.getSingleResult();

		System.out.println(String.format("The SUM of all movimentations is: %f", sumOfMovimentations));
	}
}
