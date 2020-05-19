package com.jetherrodrigues.executions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jetherrodrigues.dao.ConnectionFactory;
import com.jetherrodrigues.dao.GenericDao;
import com.jetherrodrigues.domain.AccountMovimentation;
import com.jetherrodrigues.domain.Category;

public class JpqlMovimentationOfOneCategory {
	public static void main(String[] args) {
		final EntityManager em = ConnectionFactory.getEntityManager();

		final String jpql = "select m from AccountMovimentation m join m.categories c where c = :pCategory";

		final GenericDao<Category> categoryDao = new GenericDao<Category>();
		final Category category = categoryDao.findById(Category.class, 1L);
		
		final TypedQuery<AccountMovimentation> query = em.createQuery(jpql, AccountMovimentation.class);
		query.setParameter("pCategory", category);

		final List<AccountMovimentation> movimentations = query.getResultList();
		movimentations.forEach(System.out::println);
	}
}
