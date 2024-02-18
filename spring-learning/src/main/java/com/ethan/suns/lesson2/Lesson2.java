package com.ethan.suns.lesson2;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson2 {
	public static void main(String[] args) {
		//Debug查看Spring解析xml标签流程
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
		User user = (User) classPathXmlApplicationContext.getBean("z");
		System.out.println("user ------>>>" + user);

	}
}
