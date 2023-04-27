package com.learn.no_5.fieldEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main01 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-field-editor01-test.xml");
		//若无属性编辑器 String类型的birthDay无法转换为 Date类型
		Student bean = (Student)applicationContext.getBean("student");
		System.out.println(bean);
	}
}
