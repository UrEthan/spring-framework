package com.learn.no_6.demo02;

import com.learn.no_6.demo01.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Main {
	public static void main(String[] args) {
		/**
		 * 多重代理的一种实现方式 一种多次增强的方式
		 * 代码实现较为繁琐
		 */
		//1.第一步 创建目标对象
		Cat cat = new Cat();
		//2.代理对象
		JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(cat);
		//只被代理了一层的 代理对象
		Animal proxy01 = (Animal)jdkDynamicProxy.getProxy();
		proxy01.eat();
		System.out.println("---------------分隔符--------------------");
		//3.第二次代理 需要 JdkDynamicProxy2 + proxy01
		JdkDynamicProxy2 dynamicProxy2 = new JdkDynamicProxy2(proxy01);
		Animal proxy02 = (Animal)dynamicProxy2.getProxy();
		proxy02.eat();
	}
}
