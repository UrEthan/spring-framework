package com.learn.no_5.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

public class ReplaceObscenitiesBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private Set<String> obscenities;

	public ReplaceObscenitiesBeanFactoryPostProcessor() {
		this.obscenities = new HashSet<>();
	}

	public Set<String> getObscenities() {
		return obscenities;
	}

	public void setObscenities(Set<String> obscenities) {
		this.obscenities.clear();
		for (String obscenity : obscenities) {
			this.obscenities.add(obscenity);
		}
		this.obscenities = obscenities;
	}

	public boolean isObscene(Object value) {
		String upperCase = value.toString().toUpperCase();
		return obscenities.contains(upperCase);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
			StringValueResolver resolver = strVal -> {
				if (isObscene(strVal)) {
					return "**********";
				}
				return strVal;
			};
			BeanDefinitionVisitor beanDefinitionVisitor = new BeanDefinitionVisitor(resolver);
			beanDefinitionVisitor.visitBeanDefinition(beanDefinition);
		}

	}
}
