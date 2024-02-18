package com.learn;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import com.suns.lesson2.User;

public class Main {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("classpath:spring.xml");
		//UserService bean = (UserService)applicationContext.getBean("userService");

		XmlBeanFactory applicationContext = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		//父子容器
		//DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory(applicationContext);
		Object bean = applicationContext.getBean("user");
		if (bean instanceof User){
			System.out.println("我是实现了BeanFactory接口的 new 出来的User对象 =====》"+bean);
			User user = (User) bean;
			//System.out.println("===>"+user.getId());
		}else if (bean instanceof FactoryBean){
			FactoryBean bf = (UserFactoryBean) bean;
			User object = (User)bf.getObject();
			System.out.println(object.getName());
			System.out.println("我是被实现了BF的工厂实例 --->"+bean);
		}
		//UserService bean = applicationContext.getBean("userService", UserService.class);
		//获取自定义标签
		/*suns.lesson2.User user = (suns.lesson2.User)applicationContext.getBean("zhuanning");
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		//按照类型获取bean 抛异常 该类有两个bd 按照类型去取不知道用哪一个
		//UserService bean = applicationContext.getBean(UserService.class);
		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
			System.out.println("bd名称======>"+beanDefinitionName);
		}


		User userById = bean.getUserById(1);
		System.out.println(userById+ "----------打印结果-----------");
		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();*/
	}
}
