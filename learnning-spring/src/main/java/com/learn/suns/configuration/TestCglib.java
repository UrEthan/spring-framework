package com.learn.suns.configuration;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

public class TestCglib {
	public static void main(String[] args) {
		/**
		 * 1.原始对象
		 * 2.基于接口还是基于继承父类
		 * 3.类加载
		 * 4.额外功能 -- 增强方法
		 */
		/*Enhancer enhancer = new Enhancer();
		Aa a = new Aa();
		enhancer.setSuperclass(Aa.class);
		enhancer.setClassLoader(TestCglib.class.getClassLoader());
		enhancer.setCallback(new InvocationHandler() {
			@Override
			public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
				System.out.println("增加对@Scope注解的支持");
				return method.invoke(a,args);
			}
		});
		//创建代理
		Aa proxy = (Aa)enhancer.create();
		//调用会走到InvocationHandler方法
		proxy.m1();
		User user = new User();
		String code = "12";*/


	}
}
