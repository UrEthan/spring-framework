package com.suns.lesson6;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/** 1%
 * 选择情况:如果不存在实际的.class,需要动态字节码技术运行创建的类型,例如动态代理 选择 ImportBeanDefinitionRegistrar
 * 配置类AppConfig上 @Import(MyBdImportRegister.class)
 * 这个接口实现灵活度比Selector更高;  使用点:MyBatis和Spring整合
 */
public class MyBdImportRegister implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//创建动态字节码 -> 创建bd
		//引入代码进行处理 -> 生成动态的类型
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
		registry.registerBeanDefinition("xxx",beanDefinition);
	}

}
