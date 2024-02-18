package com.ethan.suns.lesson2;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		String password = element.getAttribute("password");
		builder.addPropertyValue("name",name);
		builder.addPropertyValue("password",password);
	}
}
