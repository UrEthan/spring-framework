package com.learn.suns.invokeBeanFactoryPostProcessors;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
//@Import(User.class)
public class MyImportBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("--------------调用MyImportBeanDefinitionRegistry中registerBeanDefinitions方法------------------");
		//registry.registerBeanDefinition();
	}
}
