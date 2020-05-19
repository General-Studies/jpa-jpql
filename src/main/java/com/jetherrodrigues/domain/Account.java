package com.jetherrodrigues.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public final class Account implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Integer branch;
	@NotNull
	private Integer number;
	@NotNull
	private BigDecimal amount;

	public Account branch(final Integer branch) {
		this.branch = branch;
		return this;
	}
	
	public Account number(final Integer number) {
		this.number = number;
		return this;
	}
	
	public Account withAmount(final BigDecimal amount) {
		this.amount = amount;
		return this;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Integer getBranch() {
		return branch;
	}

	public void setBranch(final Integer branch) {
		this.branch = branch;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(final BigDecimal amount) {
		Objects.requireNonNull(amount, "The amount can't be null!");
		this.amount = amount;
	}

}
