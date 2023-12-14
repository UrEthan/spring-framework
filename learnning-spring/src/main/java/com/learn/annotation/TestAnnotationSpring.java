package com.learn.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotationSpring {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Product product = (Product)ctx.getBean("product");
		Account account = (Account)ctx.getBean("account");
		System.out.println("---->" + product);
		System.out.println("---->" + account);


	}
}
