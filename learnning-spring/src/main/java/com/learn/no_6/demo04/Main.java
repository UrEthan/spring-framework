package com.learn.no_6.demo04;

import com.learn.no_6.demo01.Animal;
import com.learn.no_6.demo01.Cat;

public class Main {
	public static void main(String[] args) {
		//1.第一步 创建目标对象
		Cat cat = new Cat();
		// 2.创建代理对象
		JdkDynamicProxy proxy = new JdkDynamicProxy(cat);
		//3.使用方法拦截器 去增强方法
		proxy.addInterceptor(new InterceptorOne());
		proxy.addInterceptor(new InterceptorTwo());
		//4.获取代理对象
		Animal animal = (Animal)proxy.getProxy();
		animal.eat();


	}
}
