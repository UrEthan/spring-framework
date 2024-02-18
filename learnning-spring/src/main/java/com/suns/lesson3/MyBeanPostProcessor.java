package com.suns.lesson3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 将此类交给容器 其他所有的bean都会经过该类处理
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("*********执行bean后置处理器 AfterInitialization *************");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("《- - - -执行bean前置处理器 BeforeInitialization- - - 》");
		return bean;
	}
}
