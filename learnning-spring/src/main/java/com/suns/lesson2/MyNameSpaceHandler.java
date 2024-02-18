package com.suns.lesson2;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义标签处理器
 * 注册对应的解析器 UserBeanDefinitionParser
 */
public class MyNameSpaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		//注册标签user由谁来做解析 TODO：注册时错误的用了suns标签头,所以一直报错,后改为user后成功
		registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
	}
}
