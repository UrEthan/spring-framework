package com.ethan.suns.lesson3;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring注入分为几种方式？
 * 1.set注入(程序员完成注入 8种基本类 自建注入 ref-bean;容器Spring自己的注入)
 * 2.构造注入
 * 3.autowire自动注入
 */
public class Lesson3 {
	public static void main(String[] args) {
		//Debug查看Spring解析xml标签流程
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
		User user = (User) classPathXmlApplicationContext.getBean("u");
		System.out.println("user ------>>>" + user);
		user.showFactoryName();

	}
}
