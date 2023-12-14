package com.learn.no_6.demo05;

import com.learn.no_6.demo01.Animal;
import com.learn.no_6.demo01.Cat;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Main {
	public static void main(String[] args) {
		//创建被代理对象
		Cat cat = new Cat();
		//创建Spring代理工厂对象 proxyFactory
		//ProxyFactory是 Config + Factory 的存在 持有AOP操作所有的生产资料
		ProxyFactory proxyFactory = new ProxyFactory(cat);

		proxyFactory.addAdvice(new MethodInterceptor01());
		proxyFactory.addAdvice(new MethodInterceptor02());
		//指定方法增强而不是两个都增强
		proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new MyPointCut(),new MethodInterceptor01()));
		Animal proxy = (Animal)proxyFactory.getProxy();
		proxy.eat();
		System.out.println("--------------------");
		proxy.go();

	}
}
