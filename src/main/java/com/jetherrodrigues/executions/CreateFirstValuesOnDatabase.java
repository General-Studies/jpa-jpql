package com.jetherrodrigues.executions;

import java.math.BigDecimal;
import com.jetherrodrigues.dao.GenericDao;
import com.jetherrodrigues.domain.Account;
import com.jetherrodrigues.domain.AccountMovimentation;
import com.jetherrodrigues.domain.Category;
import com.jetherrodrigues.domain.Client;
import com.jetherrodrigues.domain.OperationType;

public class CreateFirstValuesOnDatabase {
	
	public static void main(String[] args) {
		final Account account = saveAccount();
		
		saveClient(account);
		
		final AccountMovimentation input = saveAccountMovimentation(getInputAccountMovimentation(account));
		final AccountMovimentation output = saveAccountMovimentation(getOutputAccountMovimentation(account));
		
		final Category salary = saveCategory(new Category("Salary"));
		final Category food = saveCategory(new Category("Food"));
		
		input.addCategory(salary);
		output.addCategory(food);
		
		saveAccountMovimentation(input);
		saveAccountMovimentation(output);
		
	}

	private static Category saveCategory(final Category category) {
		final GenericDao<Category> dao = new GenericDao<Category>();
		return dao.saveOrUpdate(category);
	}
	
	private static Account saveAccount() {
		final GenericDao<Account> dao = new GenericDao<Account>();

		final Account account = new Account()
				.branch(1)
				.number(1203456)
				.withAmount(BigDecimal.valueOf(200.0));

		return dao.saveOrUpdate(account);
	}
	
	private static Client saveClient(final Account account) {
		final GenericDao<Client> dao = new GenericDao<Client>();

		final Client client = new Client()
				.name("Jether Rodrigues do Nascimento")
				.email("jether.rodrigues@test.com")
				.account(account);

		return dao.saveOrUpdate(client);
	}
	
	private static AccountMovimentation saveAccountMovimentation(final AccountMovimentation accountMovimentation) {
		final GenericDao<AccountMovimentation> dao = new GenericDao<AccountMovimentation>();
		return dao.saveOrUpdate(accountMovimentation);
	}
	
	private static AccountMovimentation getInputAccountMovimentation(final Account account) {
		return new AccountMovimentation()
				.description("Salary")
				.operation(OperationType.INPUT)
				.amount(new BigDecimal(300.0))
				.account(account);
	}
	
	private static AccountMovimentation getOutputAccountMovimentation(final Account account) {
		return new AccountMovimentation()
				.description("Food Purchase")
				.operation(OperationType.OUTPUT)
				.amount(new BigDecimal(50.0))
				.account(account);
	}
}
