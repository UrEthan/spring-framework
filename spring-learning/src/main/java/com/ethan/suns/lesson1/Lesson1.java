package com.ethan.suns.lesson1;

import com.ethan.pojo.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Lesson1 {
	public static void main(String[] args) {
		/**
		 * XmlBeanFactory - 读取XML配置文件 创建对应的对象
		 * Resource接口 --> ClassPathResource实现
		 * --> xml解析 --> resource --> XmlBeanDefinitionReader(读取xml、封装成bd)
		 * Spring配置文件在JVM中以何种形式体现？ --> BeanDefinition (mybatis中是以Configuration以及MappedStatement体现的)
		 */
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
		User user = (User)beanFactory.getBean("user");
		System.out.println("user = " + user);
		// 替换以上代码实现 DefaultListableBeanFactory 替换XmlBeanFactory；  + XmlBeanDefinitionReader
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		Resource classPathResource = new ClassPathResource("application.xml");
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		User bean = (User)defaultListableBeanFactory.getBean("user");
		System.out.println("替换之后获取user = " + bean);

	}
}
