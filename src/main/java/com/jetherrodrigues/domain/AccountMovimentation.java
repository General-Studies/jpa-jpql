package com.jetherrodrigues.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries ({
	@NamedQuery(name="findSumOfAccountMovimentation", query = "select sum(am.amount) from AccountMovimentation am"),
	@NamedQuery(
		name="findSumOfAccountMovimentationUsingJoinAnd", 
		query = "select am from AccountMovimentation am where am.account = :pAccount and am.operationType = :pOperationType")
})
public final class AccountMovimentation implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@NotNull
	private BigDecimal amount;
	private LocalDateTime operationDate = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private OperationType operationType;

	@NotNull
	@ManyToOne
	private Account account;
	@NotNull
	@OneToMany
	private List<Category> categories = new ArrayList<Category>();

	public AccountMovimentation description(final String description) {
		this.description = description;
		return this;
	}
	
	public AccountMovimentation amount(final BigDecimal amount) {
		this.amount = amount;
		return this;
	}
	
	public AccountMovimentation operation(final OperationType operationType) {
		this.operationType = operationType;
		return this;
	}
	
	public AccountMovimentation account(final Account account) {
		this.account = account;
		return this;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(LocalDateTime operationDate) {
		this.operationDate = operationDate;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account conta) {
		this.account = conta;
	}

	public List<Category> getCategorias() {
		return Collections.unmodifiableList(categories);
	}

	public AccountMovimentation addCategory(final Category category) {
		this.categories.add(category);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountMovimentation [id=").append(id).append(", description=").append(description)
				.append(", amount=").append(amount).append(", operationDate=").append(operationDate)
				.append(", operationType=").append(operationType).append(", account=").append(account)
				.append(", categories=").append(categories).append("]");
		return builder.toString();
	}
}
