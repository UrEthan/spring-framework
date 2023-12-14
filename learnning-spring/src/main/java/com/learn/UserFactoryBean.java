package com.learn;

import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		User user = new User();
		user.setId("user1");
		user.setName("张飞龙总");
		user.setPassword("1212121212");
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
