package com.learn.suns.beanfactoryProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

//@Component //被Spring感知
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("《---------自定义postProcessBeanFactory--------》");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		//修改a的 bd
		//BeanDefinition beanDefinition = registry.getBeanDefinition("a");
		//beanDefinition.setScope("prototype");
		System.out.println("---------自定义postProcessBeanDefinitionRegistry--------");
	}
}
