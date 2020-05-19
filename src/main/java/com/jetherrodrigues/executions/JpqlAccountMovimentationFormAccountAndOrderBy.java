package com.jetherrodrigues.executions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jetherrodrigues.dao.ConnectionFactory;
import com.jetherrodrigues.domain.Account;
import com.jetherrodrigues.domain.AccountMovimentation;

public class JpqlAccountMovimentationFormAccountAndOrderBy {
	
	public static void main(String[] args) {
		
		final EntityManager em = ConnectionFactory.getEntityManager(); 
		
		final String jpql = "select m from AccountMovimentation m where m.account = :pAccount order by m.amount desc";
		
		final Account account = new Account();
		account.setId(1L);
		
		final TypedQuery<AccountMovimentation> query = em.createQuery(jpql, AccountMovimentation.class);
		query.setParameter("pAccount", account);
		
		final List<AccountMovimentation> movimentations = query.getResultList();
		movimentations.forEach(System.out::println);
	}
}
