package com.jetherrodrigues.executions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jetherrodrigues.dao.ConnectionFactory;
import com.jetherrodrigues.dao.GenericDao;
import com.jetherrodrigues.domain.Account;
import com.jetherrodrigues.domain.AccountMovimentation;
import com.jetherrodrigues.domain.Category;

/**
 * Here we have JOIN example
 * 
 * We are selecting account movimentation inner join category
 * and in other example inner join account
 */
public class JpqlJoin {
	public static void main(String[] args) {
		final EntityManager em = ConnectionFactory.getEntityManager();

		final String jpqlCategory = "select m from AccountMovimentation m join m.categories c where c = :pCategory";

		final GenericDao<Category> categoryDao = new GenericDao<Category>();
		final Category category = categoryDao.findById(Category.class, 1L);
		
		final TypedQuery<AccountMovimentation> queryCategory = em.createQuery(jpqlCategory, AccountMovimentation.class);
		queryCategory.setParameter("pCategory", category);

		final List<AccountMovimentation> movimentationsJoinCategory = queryCategory.getResultList();
		movimentationsJoinCategory.forEach(System.out::println);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		final String jpqlAccount = "select m from AccountMovimentation m join m.account a where a = :pAccount";

		final GenericDao<Account> accountDao = new GenericDao<Account>();
		final Account account = accountDao.findById(Account.class, 1L);
		
		final TypedQuery<AccountMovimentation> queryAccount = em.createQuery(jpqlAccount, AccountMovimentation.class);
		queryAccount.setParameter("pAccount", account);

		final List<AccountMovimentation> movimentationsJoinAccount = queryAccount.getResultList();
		movimentationsJoinAccount.forEach(System.out::println);
	}
}
