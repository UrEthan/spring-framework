package com.learn.no_5.lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle-test.xml");
		ac.start();
		ac.stop();
	}
}
