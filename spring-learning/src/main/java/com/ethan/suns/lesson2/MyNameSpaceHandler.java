package com.ethan.suns.lesson2;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义标签处理器
 * 注册对应的解析器 UserBeanDefinitionParser
 */
public class MyNameSpaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
	}
}
