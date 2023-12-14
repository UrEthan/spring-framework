package com.learn.no_7.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-test.xml");
		TestInterface bean = (TestImpl)ac.getBean("test");
		bean.doSomeTest();
		System.out.println("--------------------");
		bean.doOtherTest();
		System.out.println("--------------------");
		bean.a();
		bean.b();
	}
}
