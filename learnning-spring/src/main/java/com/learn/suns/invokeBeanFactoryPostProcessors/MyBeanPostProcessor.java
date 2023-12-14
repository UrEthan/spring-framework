package com.learn.suns.invokeBeanFactoryPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 添加@Component注解的BeanPostProcessor 会在invokeBeanFactoryPostProcessors方法中完成注册
 * （这里的注册是将其注册到DefaultListableBeanFactory中的beanPostProcessors中）
 *
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("*********执行bean后置处理器*************");
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("《- - - -执行bean前置处理器 - - - 》");
		return null;
	}
}
