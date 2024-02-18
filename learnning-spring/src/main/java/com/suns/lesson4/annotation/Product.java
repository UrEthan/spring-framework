package com.suns.lesson4.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 注解注入到Spring容器
 * 该类又注入了account
 */
@Component
public class Product {

	@Value("${product.id}")
	private Integer id;
	@Value("${product.name}")
	private String name;
	@Autowired
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", account=" + account +
				'}';
	}
}
