package com.learn.suns.mybatis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 模拟Spring整合mybatis
 * 因为在Mybatis中 Dao为接口没有实现类 但是service缺可以直接使用@Autowired注入的Dao 探究其原理
 * 1.要想service使用Dao 则必须将dao的实现类注册到Spring容器中
 * 2.通过FactoryBean实现Dao代理 并通过手动 注册的方式
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService)context.getBean("userServiceImpl");
		userService.register();

	}
}
