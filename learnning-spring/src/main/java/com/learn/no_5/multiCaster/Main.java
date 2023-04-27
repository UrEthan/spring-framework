package com.learn.no_5.multiCaster;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-multicaster-test.xml");
		TestEvent testEvent = new TestEvent("","我来了····!");
		ac.publishEvent(testEvent);
	}
}
