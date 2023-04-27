package com.learn.no_5.beanFactoryPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-bfpb-test.xml");
		Book b1 = (Book)ac.getBean("book-01");
		Book b2 = (Book)ac.getBean("book-02");
		Book b3 = (Book)ac.getBean("book-03");
		//b2 b3的结果被过滤掉了
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
}
