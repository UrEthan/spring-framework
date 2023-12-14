package com.learn.suns.other;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
public class TestApplication {
	public static void test(){
		//1.set方式获取bd
		GenericBeanDefinition gbd = new GenericBeanDefinition();
		gbd.setBeanClassName("bean");
		//2.第二种方式获取bd
		AnnotatedGenericBeanDefinition annotatedBd = new AnnotatedGenericBeanDefinition(AppConfig.class);
		//3.通过另一种方式完成bd的获取 ---建造者模式
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(AppConfig.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanDefinitionBuilder.getBeanDefinition();
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		propertyValues.add("key","value");
	}
}
