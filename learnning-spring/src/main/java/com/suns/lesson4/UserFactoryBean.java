package com.suns.lesson4;

import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		User user = new User();
		user.setId("lesson4");
		user.setName("factoryBean-test");
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
