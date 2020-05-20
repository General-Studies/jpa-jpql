package com.jetherrodrigues.executions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jetherrodrigues.dao.ConnectionFactory;
import com.jetherrodrigues.dao.GenericDao;
import com.jetherrodrigues.domain.Account;
import com.jetherrodrigues.domain.AccountMovimentation;
import com.jetherrodrigues.domain.OperationType;

public class JpqlNamedQueryJoinAnd {
	
	public static void main(String[] args) {
		
		final EntityManager em = ConnectionFactory.getEntityManager(); 
		
		final GenericDao<Account> accountDao = new GenericDao<>();
		final Account account = accountDao.findById(Account.class, 1L);

		final TypedQuery<AccountMovimentation> typedQuery = em.createNamedQuery("findSumOfAccountMovimentationUsingJoinAnd", AccountMovimentation.class)
			.setParameter("pAccount", account)
			.setParameter("pOperationType", OperationType.OUTPUT);

		final List<AccountMovimentation> customers = typedQuery.getResultList();

		customers.forEach(System.out::println);
	}
}
