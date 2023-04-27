package com.learn;
import com.learn.pojo.User;
import com.learn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
		UserService bean = (UserService)applicationContext.getBean("userService");
		User userById = bean.getUserById(1);
		System.out.println(userById+ "----------打印结果-----------");
		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
	}
}
