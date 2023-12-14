package com.learn.suns.beanfactoryProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 修改bd信息
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		A a = (A)context.getBean("a");
		A a1 = (A)context.getBean("a");
		System.out.println(a);
		System.out.println(a1);
		System.out.println("------------------------------------");
		//修改bd 添加拓展 这种方式相当于是在refresh之后添加的，没有机会去感知 故不生效
		//context.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
		//通过拆分用无参构造context  将addBeanFactoryPostProcessor步骤放置在refresh之前运行
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.register(A.class); //先要注册A才行，否则addBeanFactoryPostProcessor时还未refresh 没有a的bd
		ctx.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
		ctx.refresh();// 这个步骤会注册a的bean 放后面会报错
		A a2 = (A)ctx.getBean("a");
		A a3 = (A)ctx.getBean("a");
		System.out.println(a2);
		System.out.println(a3);
	}
}
