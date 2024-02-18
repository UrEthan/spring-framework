package com.suns.lesson3;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Spring有几种方式创建对象？
 * 1.简单对象 我们一般是new对象() Spring一般基于反射完成
 * 2.复杂对象 不能被直接new的对象
 *  -- Spring一般实现 FactoryBean 接口 创建方式；其中三个方法getObject() getObjectType() isSingleton() Spring初始化过程中回去回调 FactoryBean接口的实现类中方法
 *  -- 若不实现 FactoryBean接口又想让Spring感知 静态工厂 <bean id="staticFactory" class="xxx.StaticFactory" init-method="getObject"/> 意思是 StaticFactory 类中静态方法getObject创造复杂对象
 *  StaticFactory{
 *      public static Object getObject(){ xxx 具体实现复杂对象的逻辑}
 *  }
 *  --实例工厂因为getObject()不是静态方法 所以需要先构建 MyFactory实例对象 然后调用方法
 *  <bean id="myFactory" class="xxx.MyFactory"/> --> 构建对象然后 <bean id="product" factory-bean="myFactory" init-method="getObject"/>
 *  --------以上步骤就是通过各种方式把对象创建出来 User user = new User(); 创建好的对象还要对其成员变量进行赋值，那就考虑如何注入---------------
 * Spring 注入分为几种方式？(成员变量赋值的过程)
 * 1.set注入 推荐使用:1.避免了构造器注入的重载问题 2.Spring内部大量使用 3.避免循环引用 (程序员完成注入 8种基本类 自建注入 ref-bean;Spring容器自己的注入)
 * --容器级的注入:User类实现接口，实质上也都实现了set方法 一堆 Aware 接口 例如:BeanNameAware(当前对象获得它在工厂中的id) or BeanFactoryAware (当前对象获得 当前工厂对象)
 * --用户的set再前，容器的注入在后面
 * 2.构造注入(时机:伴随着对象创建)
 * 3.autowire自动注入
 * 综上所述即: 创建对象 - 属性注入 - 加工 postProcessor - 初始化赋值(init-method) - 再次加工postProcessor - 对象使用 - 销毁(destory)
 * 拆分这么多步骤 beanPostProcessor 主要还是为了 减少加工代码的冗余、解掉加工代码的耦合
 */
public class Lesson3 {
	public static void main(String[] args) {
		//BeanFactory classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
		XmlBeanFactory classPathXmlApplicationContext = new XmlBeanFactory(new ClassPathResource("application.xml"));
		User user = (User) classPathXmlApplicationContext.getBean("ttt");
		System.out.println("user ------>>>" + user);
		//容器"告知"了User对象 其在容器中的id名称 让其"意识"到
		user.showFactoryName();
		user.showMyFactory();
		//验证 --> 两个beanFactory是同一个 引用完全相同 但是用ClassPathXmlApplicationContext是不一样的可以打开注释验证
		System.out.println("创建的工厂" + classPathXmlApplicationContext);
		test(classPathXmlApplicationContext);
	}

	public static void test(XmlBeanFactory beanFactory) {
		//BeanFactoryAware 解决 bean scope=prototype 注入过程失效的问题
		//即Service类注入了 scope=prototype的Dao类 但通过打印发现 Dao的bean都是同一个 在多线程情况下会有线程安全问题，必须让每个service使用自己的dao
		//故 service实现 BeanFactoryAware 接口，然后通过id获取 dao 解决注入失效问题
		UserService userService1 = (UserService)beanFactory.getBean("userService");
		UserService userService2 = (UserService)beanFactory.getBean("userService");
		userService1.register();
		userService2.register();
		//以下方式 则没有失效 故service不用注入的方式
		UserDao userDao1 = (UserDao)beanFactory.getBean("userDao");
		UserDao userDao2 = (UserDao)beanFactory.getBean("userDao");
		System.out.println(userDao1);
		System.out.println(userDao2);
		//关闭容器 触发销毁方法
		beanFactory.destroySingletons();
		//测试 myBeanPostProcessor
		BeanFactory classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
		User user = (User) classPathXmlApplicationContext.getBean("u");
	}
}
