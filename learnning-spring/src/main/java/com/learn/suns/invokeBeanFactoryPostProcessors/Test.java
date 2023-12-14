package com.learn.suns.invokeBeanFactoryPostProcessors;

import com.learn.suns.beanfactoryProcessor.MyBeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//下面三个步骤等价于上面一个步骤 好处是可以进行个性化定制 在工厂实例化的时候添加BeanFactoryPostProcessor
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.register(Aa.class);
		//ctx.addBeanFactoryPostProcessor(new MyBdRegistryPostProcessor());//其实就是给成员变量List<BeanFactoryPostProcessor>赋值 此时可运行
		ctx.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
		ctx.refresh();

	}
}
