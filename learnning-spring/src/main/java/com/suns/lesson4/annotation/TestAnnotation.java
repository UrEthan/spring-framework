package com.suns.lesson4.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解的处理:
 * 1.首先定义配置类 AppConfig 并用 @Configuration 标识为配置类
 * 2.通过 @ComponentScan("com.suns.lesson4.annotation")进行注解扫描以及扫描的包的范围
 * 3.通过 @PropertySource("classpath:app.properties") 引入了外部的配置文件 app.properties 提供了对象属性以及值
 * 4.创建了 Account 和 Product 两个类 其中Product中的 @Value 注解是针对基本类型的赋值 (注解形式的解析基于AutowiredAnnotationBeanPostProcessor)
 */
public class TestAnnotation {
	public static void main(String[] args) {
		/*注解方式*/
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Product product = context.getBean("product", Product.class);
		System.out.println("---------------->>>>>>"+product);
	}
}
