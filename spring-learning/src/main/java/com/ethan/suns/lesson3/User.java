package com.ethan.suns.lesson3;

import org.springframework.beans.factory.BeanNameAware;

public class User implements BeanNameAware {
	private String id;

	private String name;

	private String userFactoryName;

	@Override
	public void setBeanName(String name) {
		//spring会回调该方法
		this.userFactoryName = name;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showFactoryName(){
		System.out.println(" bean id is --->>>" + userFactoryName);
	}
}
