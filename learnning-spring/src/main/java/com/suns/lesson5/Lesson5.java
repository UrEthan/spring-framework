package com.suns.lesson5;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  循环引用的问题: -> 结论:
 *  1.Spring只解决了两个对象都是单实例情况下,且都通过setter方法注入的 循环引用问题
 *  2.两个对象都是单实例情况下,通过构造方法注入的循环引用问题  - 未解决
 *  3.两个对象都是多实例的情况下,且注入过程无论使用setter方法或者构造器 - 未解决
 *  ----------------------------
 *  <<循环引用演示: A - {private B b;}  B - {private A a;}>>
 *  1.beanFactory.getBean("a"); -> getSingleton("a") (第一次:单例池、工厂池、早期对象池都为空) -> createBeanInstance创建a实例(半成品)
 *  -> 工厂池.put(beanNameA,()->getEarlyReference()) -> populateBean(属性填充:发现依赖B) -> beanFactory.getBean("b")
 *  2.beanFactory.getBean("b") => getSingleton("b") (第一次:单例池、工厂池(此时只有a)、早期对象池都为空) => createBeanInstance创建b实例(半成品)
 *  => 工厂池.put(beanNameB,()->getEarlyReference()) -> populateBean(属性填充:发现依赖A) -> beanFactory.getBean("a")
 *  3.beanFactory.getBean("a") -> 单例工厂singletonFactories获取到()->getEarlyReference() 执行lambda表达式 --> 获取早期对象并返回(如果是代理对象,该引用方法会做代理)
 *  4.完成了B的属性填充(Spring的) -> 完成B的初始化操作(各种aware,人工的)[其中包含B是否做代理,创建B代理] -> singletonObjects.put(b,b的实例maybe代理对象)
 *  5.A获取到B实例完成属性填充 => 进行A的初始化操作,无需做代理直接从创建过代理的池子获取代理对象 => singletonObjects.put(a,a的实例maybe代理对象)
 *  6.完成所有流程
 */
public class Lesson5 {
	public static void main(String[] args) throws Exception {
		/*注解方式*/
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		A a = (A)context.getBean("a");
		a.showB();
		B b = context.getBean("b", B.class);
		b.showA();
	}



}
