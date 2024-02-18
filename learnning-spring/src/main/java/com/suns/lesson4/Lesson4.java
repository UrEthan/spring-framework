package com.suns.lesson4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 *  * 1.工厂bean的获取 工厂bean中创建对象的获取
 * 2.父子容器中 bean的获取
 * 3.getMergedLocalBeanDefinition
 */
public class Lesson4 {
	public static void main(String[] args) throws Exception {
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
		//获取工厂对象
		/*UserFactoryBean bean = xmlBeanFactory.getBean("&lesson4", UserFactoryBean.class);
		Object object = bean.getObject();*/
		//获取工厂对象创建的实例
		Object bean = xmlBeanFactory.getBean("lesson4");
		System.out.println(bean);
		//测试父子容器
		//testParentChildContext();
		//测试getMergedLocalBeanDefinition
		testMergedBean();
	}

	/**
	 * 重点测试:getMergedLocalBeanDefinition功能
	 * 结果是将父子bean进行合并之后输出
	 */
	private static void testMergedBean() {
		DefaultListableBeanFactory parent = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(parent);
		xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("application-parent.xml"));
		Product sunsP = parent.getBean("sunsP", Product.class);
		System.out.println("获取mergedBean后的对象 --->" + sunsP);

	}

	/**
	 * 测试父子容器整合问题(父子容器有相同的配置 以子容器为主)
	 * 实战中的父子容器: SpringMVC DispatcherServlet child （由于以上的问题 SpringMVC在注解扫描的时候还不能让子容器扫描所有 它只能扫描controller 防止子容器覆盖父容器的 bean）
	 *                          ContentLoaderListener root
	 */
	public static void testParentChildContext(){
		//创建父容器
		DefaultListableBeanFactory parent = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(parent);
		xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("application-parent.xml"));
		//创建子容器 - 将父容器 parent 作为子容器参数传入即可(建立父子容器之间的关联)
		DefaultListableBeanFactory child = new DefaultListableBeanFactory(parent);
		XmlBeanDefinitionReader childReader = new XmlBeanDefinitionReader(child);
		childReader.loadBeanDefinitions(new ClassPathResource("application.xml"));
		//一旦使用了父子工厂 父子工厂的配置信息会融合 Spring会整合在一起,此时可以通过子容器也可获取
		//可以debug到父子容器的使用逻辑 看看具体如何工作
		Product product = child.getBean("product", Product.class);
		System.out.println("父容器配置文件中的bean -->" + product);
		User user = child.getBean("user4", User.class);
		System.out.println("子容器配置文件中的bean -->" + user);

	}
}
