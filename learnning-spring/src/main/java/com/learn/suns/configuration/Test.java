package com.learn.suns.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		AppConfiguration bean = (AppConfiguration)context.getBean("appConfiguration");
		//User user = (User)context.getBean("user");
		for (String s : context.getBeanNamesForType(User.class)) {
			System.out.println(s);

		}


	}
	}

