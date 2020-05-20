package com.jetherrodrigues.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
public final class Client implements Serializable, BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@Email
	private String email;

	@JoinColumn(unique = true)
	@OneToOne
	private Account account;

	public Client name(final String name) {
		this.name = name;
		return this;
	}
	
	public Client email(final String email) {
		this.email = email;
		return this;
	}
	
	public Client account(final Account account) {
		this.account = account;
		return this;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=")
				.append(id)
				.append(", name=").append(name)
				.append(", email=").append(email)
				.append("]");
		return builder.toString();
	}
}
